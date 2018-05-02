/*
 * $Id: DateUtils.java, 2018年5月3日 上午12:11:23 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.xiuyu.core.util;

import java.util.Date;

/**
 * <p>
 * Title: DateUtils
 * </p>
 * <p>
 * Description:日期工具
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年5月3日 上午12:11:23
 * @modified [who date description]
 * @check [who date description]
 */
public class DateUtils {

    /**
     * 时间差別
     * @param from
     * @param to
     * @return
     */
    public static long getDiffRetLong(Date from, Date to) {
        return from.getTime() - to.getTime();
    }

}
