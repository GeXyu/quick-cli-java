/*
 * $Id: MVCResult.java, 2018年4月30日 下午12:16:41 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.xiuyu.manager.data;

import java.util.Date;

/**
 * <p>
 * Title: MVCResult
 * </p>
 * <p>
 * Description:统一返回
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年4月30日 下午12:16:41
 * @modified [who date description]
 * @check [who date description]
 */
public class MVCResult {

    private Date createTime = new Date();

    private Integer code;

    private Boolean result;

    private Object data;

    private String message;

    /**
     * @return the createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     *            the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * @param code
     *            the code to set
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * @return the data
     */
    public Object getData() {
        return data;
    }

    /**
     * @param data
     *            the data to set
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message
     *            the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the result
     */
    public Boolean getResult() {
        return result;
    }

    /**
     * @param result
     *            the result to set
     */
    public void setResult(Boolean result) {
        this.result = result;
    }

    public static MVCResult buildTrueResult() {
        MVCResult mvcResult = new MVCResult();
        mvcResult.setCode(200);
        mvcResult.setResult(true);
        return mvcResult;
    }

    /**
     * @param e
     * @return
     */
    public static MVCResult buildFalseResult(Exception e) {
        MVCResult mvcResult = new MVCResult();
        mvcResult.setCode(500);
        mvcResult.setResult(false);
        mvcResult.setMessage(e.getMessage());
        return mvcResult;
    }

    /**
     * @param user
     * @return
     */
    public static MVCResult buildTrueResult(Object data) {
        MVCResult mvcResult = new MVCResult();
        mvcResult.setCode(200);
        mvcResult.setResult(true);
        mvcResult.setData(data);
        return mvcResult;
    }
}
