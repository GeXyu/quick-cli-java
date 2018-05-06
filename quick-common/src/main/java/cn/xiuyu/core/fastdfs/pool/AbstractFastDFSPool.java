/*
 * $Id: FastDFSPool.java, 2018年5月6日 下午7:55:56 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.xiuyu.core.fastdfs.pool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * <p>
 * Title: FastDFSPool
 * </p>
 * <p>
 * Description:连接池
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年5月6日 下午7:55:56
 * @modified [who date description]
 * @check [who date description]
 */
public class AbstractFastDFSPool implements FastDFSPool {

    private static Integer MAX_POOL_SIZE = 10;
    private static Integer CORE_POOL_SIZE = 5;
    /**
     * 使用ConcurrentLinkedQueue 移除添加和扩容方面方方便，且并发安全
     */
    private Queue<FastDFSClient> clientPool = new ConcurrentLinkedQueue<FastDFSClient>();

    public AbstractFastDFSPool() {
        init(CORE_POOL_SIZE);
    }

    public AbstractFastDFSPool(int coreSize) {
        init(coreSize);
    }

    public void init(int coreSize) {
        for (int i = 0; i < coreSize; i++) {
            FastDFSClient createClient = FastDFSFactory.createClient();
            clientPool.offer(createClient);
        }
    }

    /**
     * @see cn.xiuyu.core.fastdfs.pool.FastDFSPool#getClient()
     */
    @Override
    public synchronized FastDFSClient getClient() {
        // 说明是队列为空
        if (clientPool.peek() == null) {
            return null;
        }
        FastDFSClient client = clientPool.remove();
        FastDFSClient proxy = (FastDFSClient) Proxy.newProxyInstance(client.getClass().getClassLoader(),
                client.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object obj, Method method, Object[] args) throws Throwable {
                        if (method.getName().equals("close")) {
                            // 说明入队失败
                            if (!clientPool.offer(client)) {
                                // TODO
                            }
                        } else {
                            // TODO 前置回调
                            Object invoke = method.invoke(client, args);
                            // TODO 后置回掉
                            return invoke;
                        }
                        return null;
                    }

                });
        return proxy;
    }

    /**
     * @see cn.xiuyu.core.fastdfs.pool.FastDFSPool#close(cn.xiuyu.core.fastdfs.pool.FastDFSClient)
     */
    @Override
    public void close(FastDFSClient client) {
        client.close();
    }

    /**
     * @see cn.xiuyu.core.fastdfs.pool.FastDFSPool#expand(int)
     */
    @Override
    public void expand(int maxValue) {
        // TODO
    }

    /**
     * @see cn.xiuyu.core.fastdfs.pool.FastDFSPool#expand()
     */
    @Override
    public void expand() {
        expand(MAX_POOL_SIZE);
    }

}
