package com.xzy.spring.aop.dao.impl;

import com.xzy.spring.aop.dao.ISysLogDao;
import com.xzy.spring.aop.entity.SysLog;
import com.xzy.spring.aop.mapper.SysLogMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("sysLogDao")
public class SysLogDaoImpl implements ISysLogDao {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Override
    public int insertSysLog(SysLog log) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SysLogMapper sysLogMapper = sqlSession.getMapper(SysLogMapper.class);
        int rows = sysLogMapper.insertSysLog(log);
        sqlSession.commit();
        sqlSession.close();
        return rows;
    }
}
