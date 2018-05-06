/*
 * $Id: FastDFSDataSource.java, 2018年5月6日 下午7:56:23 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.xiuyu.core.fastdfs.pool;

/**
 * <p>
 * Title: FastDFSDataSource
 * </p>
 * <p>
 * Description:fastDFS数据源接口
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年5月6日 下午7:56:23
 * @modified [who date description]
 * @check [who date description]
 */
public interface FastDFSPool {

    /**
     * 得到client
     * 
     * @return
     */
    FastDFSClient getClient();

    /**
     * 关闭
     * 
     * @param client
     */
    void close(FastDFSClient client);

    /**
     * 扩容
     * 
     * @param maxValue
     */
    void expand(int maxValue);

    /**
     * 库容
     */
    void expand();
}
