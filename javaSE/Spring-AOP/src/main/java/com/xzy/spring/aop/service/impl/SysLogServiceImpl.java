package com.xzy.spring.aop.service.impl;

import com.xzy.spring.aop.dao.ISysLogDao;
import com.xzy.spring.aop.entity.SysLog;
import com.xzy.spring.aop.mapper.SysLogMapper;
import com.xzy.spring.aop.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sysLogService")
public class SysLogServiceImpl implements ISysLogService {
    @Autowired
    private ISysLogDao sysLogDao;
    @Override
    public int createSysLog(SysLog log) {
        return sysLogDao.insertSysLog(log);
    }
}
