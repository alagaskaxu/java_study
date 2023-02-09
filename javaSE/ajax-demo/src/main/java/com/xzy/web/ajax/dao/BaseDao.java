package com.xzy.web.ajax.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    public void closeAll(  ResultSet rs,Statement s,Connection c) {
        if (rs!=null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if ( s!=null) {
            try {
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(c!=null){
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
                        throw new IllegalArgumentException("DML语句参数不能为null");
                    } else {
                        ps.setObject(index, param.toString());
                    }
                }
                status = ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            closeAll( null,ps,conn);
        }
        return status;
    }
}
