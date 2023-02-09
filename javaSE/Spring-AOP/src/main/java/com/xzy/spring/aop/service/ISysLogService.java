package com.xzy.spring.aop.service;

import com.xzy.spring.aop.entity.SysLog;

/**
 * 系统日志业务类
 */
public interface ISysLogService {
    int createSysLog(SysLog log);
}
