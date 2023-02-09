package com.xzy.spring.aop.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class SqlSessionFactoryBean {
    public final static SqlSessionFactory createSqlSessionFactory(){
        try{
            String resource = "XZY-MyBatis-config.xml";
            InputStream in = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
            return sqlSessionFactory;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
