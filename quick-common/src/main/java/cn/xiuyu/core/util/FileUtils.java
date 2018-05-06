/*
 * $Id: FileUtils.java, 2018年5月6日 下午5:49:27 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.xiuyu.core.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * <p>
 * Title: FileUtils
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年5月6日 下午5:49:27
 * @modified [who date description]
 * @check [who date description]
 */
public class FileUtils {

    public static byte[] getFileByte(File file) {
        try {
            FileInputStream input = new FileInputStream(file);
            ByteArrayOutputStream arrayByte = new ByteArrayOutputStream();

            byte[] buffer = new byte[1048];
            int lenth = 0;
            while ((lenth = input.read(buffer)) > 0) {
                arrayByte.write(buffer, 0, lenth);
            }

            input.close();
            arrayByte.close();

            return arrayByte.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }
}
