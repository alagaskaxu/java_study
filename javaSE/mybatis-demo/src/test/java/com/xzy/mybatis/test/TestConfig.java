package com.xzy.mybatis.test;


import com.xzy.mybatis.util.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

public class TestConfig {
    @Test
    public void test01(){
        try {
            String resource = "XZY-MyBatis-config.xml";
            InputStream input = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            System.out.println(sqlSession);
            System.out.println(new SqlSessionUtils().getSqlSession());
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
