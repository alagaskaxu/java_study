package com.xzy.spring.aop.dao;

import com.xzy.spring.aop.entity.SysLog;

public interface ISysLogDao {
    /**
     * 添加系统日志
     * @param log
     * @return
     */
    int insertSysLog(SysLog log);
}
