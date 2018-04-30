/*
 * $Id: BaseService.java, 2018年4月30日 下午12:23:23 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.xiuyu.core.service.base;

/**
 * <p>
 * Title: BaseService
 * </p>
 * <p>
 * Description:公共
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年4月30日 下午12:23:23
 * @modified [who date description]
 * @check [who date description]
 */
public interface BaseService<M, I> {

    /**
     * 保存
     * 
     * @param model
     * @return
     */
    M save(M model);

    /**
     * 更新
     * 
     * @param model
     * @return
     */
    M update(M model);

    /**
     * 查看
     * 
     * @param id
     * @return
     */
    M show(I id);

    /**
     * 删除
     * @param id
     * @return
     */
    M delete(I id);
}
