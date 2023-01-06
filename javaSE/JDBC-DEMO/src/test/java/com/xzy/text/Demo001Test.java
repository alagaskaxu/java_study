package com.xzy.text;

import com.xzy.jdbc.dao.DepDao;
import com.xzy.jdbc.entity.Dep;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * 单元测试类
 */

public class Demo001Test {
    /**
     * 测试Mysql数据库链接
     */
    @Test
    public void testConnection(){
        Dep dep = new Dep(4,"1001","测试",9);
        String sql = 7+"7+'"+dep.getDepCode()+"'";
        System.out.println(sql);
        try{
            //1.加载驱动类
            //com.mysql.cj.jdbc.Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.设置用户名,密码,URL
            String user="root";
            String password = "root";
            String url="jdbc:mysql://localhost:3306/demo?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useUnicode=true&useSSL=false&allowPublicKeyRetrieval=true";
            //3.利用驱动管理获取一条数据库链接
            //Connection 数据库链接(JDBC的api)
            Connection conn = DriverManager.getConnection(url,user,password);
            System.out.println(conn);
            System.out.println("ok");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("end");
    }
    @Test
    public void testInsertOne(){
        Dep dep = new Dep();
        DepDao depDap = new DepDao();
        dep.setDepCode("100014");
        dep.setDepName("后勤部");
        dep.setDepState(1);
        int row = depDap.insertDep(dep);
        System.out.println(row);
    }
    @Test
    public void testQuery() {
        DepDao depDao = new DepDao();
        List<Dep> depList = depDao.selectlist(1);
        for (Dep dep:depList){
            System.out.println(dep);
        }
    }

}
