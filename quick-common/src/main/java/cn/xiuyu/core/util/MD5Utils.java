/*
 * $Id: MD5Utils.java, 2018年5月3日 下午10:45:40 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.xiuyu.core.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * <p>
 * Title: MD5Utils
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年5月3日 下午10:45:40
 * @modified [who date description]
 * @check [who date description]
 */
public class MD5Utils {
    private static final String SLAT = "!@#%$^@";

    /**
     * 加密
     * 
     * @param password
     * @return
     */
    public static String encrypt(String password) {
        String first = DigestUtils.md5Hex(password);
        return DigestUtils.md5Hex(first + SLAT);
    }

}
