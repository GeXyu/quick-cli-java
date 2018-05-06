/*
 * $Id: AbstractFastDFSFactory.java, 2018年5月6日 下午8:31:34 XiuYu.Ge Exp $
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
import java.net.URL;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

/**
 * <p>
 * Title: AbstractFastDFSFactory
 * </p>
 * <p>
 * Description:工厂
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年5月6日 下午8:31:34
 * @modified [who date description]
 * @check [who date description]
 */
public class FastDFSFactory {

    static {
        try {
            URL resource = FastDFSFactory.class.getClassLoader().getResource("fastdfs_client.conf");
            ClientGlobal.init(resource.getPath());
        } catch (IOException | MyException e) {
            e.printStackTrace();
        }
    }

    public static FastDFSClient createClient() {
        try {
            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getConnection();
            return new AbstractFastDFSClient(trackerServer, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // -----------------------
    // ClientGlobal.setG_connect_timeout(2);
    // // 网络超时的时限，单位为秒
    // ClientGlobal.setG_network_timeout(30);
    // ClientGlobal.setG_anti_steal_token(false);
    // // 字符集
    // ClientGlobal.setG_charset("UTF-8");
    // ClientGlobal.setG_secret_key(null);
    // // HTTP访问服务的端口号
    // ClientGlobal.setG_tracker_http_port(8088);
    // // Tracker服务器列表
    // InetSocketAddress[] tracker_servers = new InetSocketAddress[1];
    // tracker_servers[0] = new InetSocketAddress("192.168.1.45", 22122);
    // ClientGlobal.setG_tracker_group(new TrackerGroup(tracker_servers));

}
