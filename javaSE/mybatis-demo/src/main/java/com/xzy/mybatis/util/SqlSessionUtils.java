package com.xzy.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * SqlSession工具类,用来获取一个SqlSession对象
 */
public class SqlSessionUtils {
    private static SqlSessionFactory sqlSessionFactory = null;
    static {
        String resource = "XZY-MyBatis-config.xml";
        try {
            InputStream input = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取sqlsession
     * @return
     */
    public static final SqlSession getSqlSession(){
        if (sqlSessionFactory!=null) {
            return sqlSessionFactory.openSession();
        }else {
            return null;
        }
    }

}
