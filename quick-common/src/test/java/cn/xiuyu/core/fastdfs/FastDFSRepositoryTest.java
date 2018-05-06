/*
 * $Id: FastDFSRepositoryTest.java, 2018年5月6日 下午9:30:09 XiuYu.Ge Exp $
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
import java.util.Map;

import org.csource.fastdfs.FileInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.xiuyu.CoreApplicationTest;

/**
 * <p>
 * Title: FastDFSRepositoryTest
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年5月6日 下午9:30:09
 * @modified [who date description]
 * @check [who date description]
 */
public class FastDFSRepositoryTest extends CoreApplicationTest {

    @Autowired
    private FastDFSRepository fastDFSRepository;

    @Test
    public void testUploadFile() {
        File file = new File("E://test.txt");
        String path = fastDFSRepository.uploadFile(file, file.getName(), file.length());
        System.out.println(path);
    }

    @Test
    public void testGetFileInfo() {
        // group1/M00/00/00/wKgBLVrvch6ASeV5AAAAAAAAAAA014.txt
        FileInfo fileInfo = fastDFSRepository.getFileInfo("group1/M00/00/00/wKgBLVrvch6ASeV5AAAAAAAAAAA014.txt");
        System.out.println(fileInfo);
    }

    @Test
    public void getFileMetadata() {
        Map<String, String> fileMetadata = fastDFSRepository
                .getFileMetadata("group1/M00/00/00/wKgBLVrvch6ASeV5AAAAAAAAAAA014.txt");
        for (String key : fileMetadata.keySet()) {
            System.out.println(key);
            System.out.println(fileMetadata.get(key));
            System.out.println("------------------------------");
        }
    }

    @Test
    public void deleteFile() {
        int status = fastDFSRepository.deleteFile("group1/M00/00/00/wKgBLVrvch6ASeV5AAAAAAAAAAA014.txt");
        System.out.println(status);
    }
}
