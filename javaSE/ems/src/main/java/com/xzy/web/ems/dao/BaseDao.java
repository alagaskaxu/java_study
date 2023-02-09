package com.xzy.web.ems.dao;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;

import java.io.Serializable;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Dao基础类
 *
 * @author luliujun
 */
public abstract class BaseDao {
    public static String user;// 用户
    public static String password;// 密码
    public static String driver;// 数据库连接驱动class类
    public static String url;// 数据库连接URL

    static {
        ResourceBundle rs = ResourceBundle.getBundle("db");
        user = rs.getString("com.xzy.db.config.user");
        password = rs.getString("com.xzy.db.config.password");
        driver = rs.getString("com.xzy.db.config.driverClassName");
        url = rs.getString("com.xzy.db.config.url");
    }

    public BaseDao() {
        super();
    }

    /**
     * 获得数据库连接
     *
     * @return
     */
    public final static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    /**
     * 回滚事务
     *
     * @param conn
     */
    public void rollBack(Connection conn) {
        if (conn != null) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭资源
     *
     * @param c
     * @param s
     * @param rs
     */
    public void closeAll(ResultSet rs, Statement s, Connection c) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (s != null) {
            try {
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (c != null) {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 执行DML语句
     *
     * @param sql
     * @param params
     * @return
     */
    public int executeUpdate(String sql, Object... params) {
        int status = -1;
        Connection conn = getConnection();
        if (null != conn) {
            PreparedStatement ps = null;
            try {
                ps = conn.prepareStatement(sql);
                int count = params.length;
                for (int index = 1; index <= count; index++) {
                    Object param = params[index - 1];
                    if (null == param) {
                        ps.setNull(index, Types.JAVA_OBJECT);
                        continue;
                        //throw new IllegalArgumentException("DML语句参数不能为null");
                    }
                    if (param instanceof java.util.Date) {
                        Date date = new Date(((java.util.Date) param).getTime());
                        ps.setDate(index, date);
                        continue;
                    }
                    ps.setObject(index, param.toString());
                }
                status = ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            closeAll(null, ps, conn);
        }
        return status;
    }
    /**
     * 根据ID查询一个对象
     *
     * @param sql         select语句
     * @param id          ID
     * @param entityClass 实体类class类型
     * @return
     */
    public Object selectById(String sql, Serializable id, Class<?> entityClass) {
        Object entity;
        try {
            entity = entityClass.newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setObject(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Map<String, String> dataMap = new HashMap<>();
                ResultSetMetaData rsMetaData = ps.getMetaData();
                //检索列名列表
                int count = rsMetaData.getColumnCount();
                for (int i = 1; i <= count; i++) {
                    //列名(字段名)
                    String columnName = rsMetaData.getColumnName(i);
                    //属性名
                    String fieldName = StrUtil.toCamelCase(columnName);//转驼峰
                    if(fieldName.equals("idcard")){
                        fieldName = "idCard";
                    }
                    //属性值
                    String fieldValue = rs.getString(columnName);
                    //用map打包数据
                    dataMap.put(fieldName, fieldValue);
                }
                //填充实体类属性值
                BeanUtil.fillBeanWithMap(dataMap, entity, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            entity = null;
        }
        closeAll(rs, ps, conn);
        return entity;
    }
}
