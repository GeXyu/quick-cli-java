/*
 * $Id: StatelessDefaultSubjectFactory.java, 2018年5月1日 上午11:32:50 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.xiuyu.manager.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;

/**
 * <p>
 * Title: StatelessDefaultSubjectFactory
 * </p>
 * <p>
 * Description:通过调用context.setSessionCreationEnabled(false)表示不创建会话；
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年5月1日 上午11:32:50
 * @modified [who date description]
 * @check [who date description]
 */
public class StatelessDefaultSubjectFactory extends DefaultWebSubjectFactory {

    /**
     * @see org.apache.shiro.web.mgt.DefaultWebSubjectFactory#createSubject(org.apache.shiro.subject.SubjectContext)
     */
    @Override
    public Subject createSubject(SubjectContext context) {
        context.setSessionCreationEnabled(false);
        return super.createSubject(context);
    }

}
