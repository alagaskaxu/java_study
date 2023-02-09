package com.xzy.spring.aop.mapper;

import com.xzy.spring.aop.entity.SysLog;

/**
 * 系统日志Mapper接口
 */
public interface SysLogMapper {
    /**
     * 添加系统日志
     * @param log
     * @return
     */
    int insertSysLog(SysLog log);
}
