package com.xzy.jdbc.dao;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * Dao层基类
 */
public abstract class BaseDao {
    /**
     * 获取数据库链接
     * @return
     */
    protected Connection getConnection(){
       try{
           //引入db.properties属性资源包
           ResourceBundle rb = ResourceBundle.getBundle("db");

           //1.加载驱动类
           //com.mysql.cj.jdbc.Driver
           Class.forName(rb.getString("com.xzy.jdbc.driverClass"));
           //2.设置用户名,密码,URL
           String user=rb.getString("com.xzy.user");
           String password = rb.getString("com.xzy.password");
           String url=rb.getString("com.xzy.jdbc.url");
           //3.利用驱动管理获取一条数据库链接
           //Connection 数据库链接(JDBC的api)
           Connection conn = DriverManager.getConnection(url,user,password);
           return conn;
       }catch (Exception e){
        throw new RuntimeException(e);
       }
    }

    /**
     * 关闭数据库资源,先关ResultSet再关statement再关Connection
     * @param rs
     * @param s
     * @param conn
     */
    protected void closeAll(ResultSet rs, Statement s, Connection conn){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (s!=null){
            try {
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
