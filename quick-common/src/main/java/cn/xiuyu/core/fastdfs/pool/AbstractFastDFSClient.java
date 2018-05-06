/*
 * $Id: FastDFSClient.java, 2018年5月6日 下午6:08:18 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.xiuyu.core.fastdfs.pool;

import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerServer;

/**
 * <p>
 * Title: FastDFSClient
 * </p>
 * <p>
 * Description:自定义元数据
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年5月6日 下午6:08:18
 * @modified [who date description]
 * @check [who date description]
 */
public class AbstractFastDFSClient extends StorageClient1 implements FastDFSClient {

    /**
     * @see cn.xiuyu.core.fastdfs.pool.FastDFSClient#ping()
     */
    @Override
    public boolean ping() {
        try {
            TrackerServer trackerServer = super.trackerServer;
            Socket socket = trackerServer.getSocket();
            return socket.getChannel().isConnected();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * @see cn.xiuyu.core.fastdfs.pool.FastDFSClient#getHost()
     */
    @Override
    public String getHost() {
        return null;
    }

    /**
     * @see cn.xiuyu.core.fastdfs.pool.FastDFSClient#close()
     */
    @Override
    public void close() {
        try {

            TrackerServer trackerServer = super.trackerServer;
            StorageServer storageServer = super.storageServer;
            if (trackerServer != null) {
                trackerServer.close();
            }
            if (storageServer != null) {
                storageServer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @see cn.xiuyu.core.fastdfs.pool.FastDFSClient#activation()
     */
    @Override
    public void activation() {
        try {
            TrackerServer trackerServer = super.trackerServer;
            Socket socket = trackerServer.getSocket();
            SocketChannel channel = socket.getChannel();
            channel.write(ByteBuffer.wrap("ping".getBytes()));
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param trackerServer
     * @param object
     */
    public AbstractFastDFSClient(TrackerServer trackerServer, StorageServer storageServer) {
        super(trackerServer, storageServer);
    }

}
