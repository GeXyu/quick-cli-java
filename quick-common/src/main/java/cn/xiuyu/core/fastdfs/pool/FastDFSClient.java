/*
 * $Id: FastDFSClient.java, 2018年5月6日 下午8:02:25 XiuYu.Ge Exp $
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

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.FileInfo;

/**
 * <p>
 * Title: FastDFSClient
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年5月6日 下午8:02:25
 * @modified [who date description]
 * @check [who date description]
 */
public interface FastDFSClient {

    /**
     * ping
     */
    boolean ping();

    /**
     * 得到host
     * 
     * @return
     */
    String getHost();

    /**
     * 关闭
     */
    void close();

    /**
     * 
     */
    void activation();

    /**
     * 上传文件
     * 
     * @param data
     * @param exdName
     * @param metaList
     * @return
     */
    String upload_file1(byte[] data, String exdName, NameValuePair[] metaList) throws IOException, MyException;

    /**
     * 下载文件
     * 
     * @param fileId
     * @return
     * @throws IOException
     * @throws MyException
     */
    byte[] download_file1(String fileId) throws IOException, MyException;

    /**
     * 得到文件详情
     * 
     * @param fileId
     * @return
     * @throws IOException
     * @throws MyException
     */
    FileInfo get_file_info1(String fileId) throws IOException, MyException;

    /**
     * 删除文件
     * 
     * @param fileId
     * @return
     * @throws IOException
     * @throws MyException
     */
    int delete_file1(String fileId) throws IOException, MyException;

    /**
     * 元数据
     * 
     * @param fileId
     * @return
     * @throws IOException
     * @throws MyException
     */
    NameValuePair[] get_metadata1(String fileId) throws IOException, MyException;

}
