/*
 * $Id: FastDFSUtils.java, 2018年5月5日 下午8:37:31 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.xiuyu.core.fastdfs;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.xiuyu.core.fastdfs.pool.FastDFSClient;
import cn.xiuyu.core.fastdfs.pool.FastDFSPool;
import cn.xiuyu.core.util.FileUtils;

/**
 * <p>
 * Title: FastDFSUtils
 * </p>
 * <p>
 * Description:fastDFS文件
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年5月5日 下午8:37:31
 * @modified [who date description]
 * @check [who date description]
 */
@Component
public class FastDFSRepository {

    @Autowired
    private FastDFSPool fastDFSPool;

    /**
     * 上传文件
     * 
     * @param file
     * @param fileName
     * @param fileLength
     * @return
     */
    public String uploadFile(File file, String fileName, long fileLength) {
        try {
            String fileExtName = null;
            if (fileName.contains(".")) {
                fileExtName = fileName.substring(fileName.lastIndexOf(".") + 1);
            }
            FastDFSClient client = fastDFSPool.getClient();
            System.out.println(client);

            NameValuePair[] metaList = new NameValuePair[3];
            metaList[0] = new NameValuePair("fileName", fileName);
            metaList[1] = new NameValuePair("fileExtName", fileExtName);
            metaList[2] = new NameValuePair("fileLength", String.valueOf(fileLength));

            String path = client.upload_file1(FileUtils.getFileByte(file), fileExtName, metaList);
            client.close();
            return path;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 下载文件
     * 
     * @param group
     * @param filePath
     * @return
     */
    public byte[] downloadFile(String fileId) {
        try {
            FastDFSClient client = fastDFSPool.getClient();
            byte[] result = client.download_file1(fileId);
            client.close();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 得到文件信息
     * 
     * @param groupName
     * @param filepath
     * @throws Exception
     */
    public FileInfo getFileInfo(String fileId) {
        try {
            FastDFSClient client = fastDFSPool.getClient();
            FileInfo info = client.get_file_info1(fileId);
            client.close();
            return info;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取元数据
     * 
     * @param fileId
     * @return
     */
    public Map<String, String> getFileMetadata(String fileId) {
        try {
            FastDFSClient client = fastDFSPool.getClient();
            NameValuePair[] metaList = client.get_metadata1(fileId);
            if (metaList != null) {
                HashMap<String, String> map = new HashMap<String, String>();
                for (NameValuePair metaItem : metaList) {
                    map.put(metaItem.getName(), metaItem.getValue());
                }
                client.close();
                return map;
            }
        } catch (IOException | MyException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 删除 返回0为成功，500 为异常，
     * 
     * @param fileId
     * @return
     */
    public int deleteFile(String fileId) {
        try {
            FastDFSClient client = fastDFSPool.getClient();
            int result = client.delete_file1(fileId);
            client.close();
            return result;
        } catch (IOException | MyException e) {
            e.printStackTrace();
        }
        return 500;

    }

}
