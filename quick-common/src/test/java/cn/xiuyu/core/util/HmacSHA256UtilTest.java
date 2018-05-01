/*
 * $Id: HmacSHA256UtilTest.java, 2018年5月1日 下午3:04:37 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.xiuyu.core.util;

import org.junit.Test;

/**
 * <p>
 * Title: HmacSHA256UtilTest
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年5月1日 下午3:04:37
 * @modified [who date description]
 * @check [who date description]
 */
public class HmacSHA256UtilTest {

    @Test
    public void testDigest() {
        String digest = HmacSHA256Utils.digest("username", "admin");
        System.out.println(digest);
    }

}
