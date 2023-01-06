package com.xzy.jdbc.dao;

import com.xzy.jdbc.entity.Emp;

import javax.sql.rowset.RowSetMetaDataImpl;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 员工数据访问层,预编译方法
 */
public class EmpDao extends BaseDao {
    /**
     * 添加一条员工数据,自动提交(隐式模式),一条数据只有成功或失败,保证事务原子性
     *
     * @param emp
     * @return
     */
    public int insertEmp(Emp emp) {
        Connection conn = getConnection();
        //预编译的sql语句
        PreparedStatement ps = null;
        int rows = -1;
        try {
            String sql = "insert into `t_emp`(`emp_code`,`emp_name`,`sex`,`idcard`,`mobile`,`birthday`,`money`,`dep_id`)values(?,?,?,?,?,?,?,?)";
            //预编译sql语句
            ps = conn.prepareStatement(sql);
            //设置占位符?的值
            ps.setString(1, emp.getEmpCode());
            ps.setString(2, emp.getEmpName());
            ps.setInt(3, emp.getSex());
            ps.setString(4, emp.getIdCard());
            ps.setString(5, emp.getMobile());
            Date birthday = emp.getBirthday();
            ps.setDate(6, birthday == null ? null : new java.sql.Date(birthday.getTime()));
            ps.setInt(7, emp.getMoney());
            ps.setInt(8, emp.getDepId());
            //更新一条sql,之后自动提交数据事务
            rows = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeAll(null, ps, conn);
        return rows;
    }

    /**
     * 根据月薪范围和所在部门查询员工信息
     *
     * @param minMoney
     * @param maxMoney
     * @param depId
     * @return
     */
    public List<Emp> selectlist(int minMoney, int maxMoney, int depId) {
        List<Emp> empList = null;
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;    //查询结果集
        try {
            String sql = "select `emp_id`,`emp_code`,`emp_name`,`money`,`dep_id` from `t_emp` where `money` between ? and ? and `dep_id` = ?;";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, minMoney);
            ps.setInt(2, maxMoney);
            ps.setInt(3, depId);
            rs = ps.executeQuery();
            empList = new ArrayList<>();
            while (rs.next()) {
                //获取字段值
                int empId = rs.getInt("emp_id");
                String empCode = rs.getString("emp_code");
                String empName = rs.getString("emp_name");
                Integer money = rs.getInt("money");
                //打包数据
                Emp emp = new Emp(empId, empCode, empName, null, null, null, null, money, depId);
                empList.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            empList = null;
        }
        //关闭资源
        closeAll(rs, ps, conn);
        return empList;
    }

    /**
     * 插入多条员工数据,多条语句需要手动提交(显示模式),防止一部分更新提交成功一部分更新提交失败,保证事务的原子性,要么全成功,要么全失败
     *
     * @param emplist
     * @return
     */
    public int insertEmpList(List<Emp> emplist) {
        Connection conn = getConnection();
        //预编译的sql语句
        PreparedStatement ps = null;
        int rows = -1;
        try {
            //将事务设置为手动提交,即关闭默认的自动提交
            conn.setAutoCommit(false);
            String sql = "insert into `t_emp`(`emp_code`,`emp_name`,`sex`,`idcard`,`mobile`,`birthday`,`money`,`dep_id`)values(?,?,?,?,?,?,?,?)";
            //预编译sql语句
            ps = conn.prepareStatement(sql);
            //设置占位符?的值
            for (Emp emp : emplist) {
                ps.setString(1, emp.getEmpCode());
                ps.setString(2, emp.getEmpName());
                ps.setInt(3, emp.getSex());
                ps.setString(4, emp.getIdCard());
                ps.setString(5, emp.getMobile());
                Date birthday = emp.getBirthday();
                ps.setDate(6, birthday == null ? null : new java.sql.Date(birthday.getTime()));
                ps.setInt(7, emp.getMoney());
                ps.setInt(8, emp.getDepId());
                //更新一条sql
                rows = ps.executeUpdate();
            }
            //前面没出错,则手动提交所有要更新的sql事务
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //出错,回滚事务
            try {
                //回滚数据事务
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        closeAll(null, ps, conn);
        return rows;
    }

    /**
     * 根据部门id查询改部门的员工
     *
     * @param depId
     * @return
     */
    public List<Emp> selectlistByDepId(int depId) {
        List<Emp> empList = null;
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;    //查询结果集
        try {
            String sql = "select`emp_id`,`emp_code`,`emp_name`,`sex`,`mobile`,`money`,`dep_id` from `t_emp` where `dep_id` = ?;";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, depId);
            rs = ps.executeQuery();
            empList = new ArrayList<>();
            while (rs.next()) {
                //获取字段值
                int empId = rs.getInt("emp_id");
                String empCode = rs.getString("emp_code");
                String empName = rs.getString("emp_name");
                int sex = rs.getInt("sex");
                String mobile = rs.getString("mobile");
                Integer money = rs.getInt("money");
                //打包数据
                Emp emp = new Emp(empId, empCode, empName, sex, null, mobile, null, money, depId);
                empList.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            empList = null;
        }
        //关闭资源
        closeAll(rs, ps, conn);
        return empList;
    }

    public int deleteEmpById(int empId) {
        int rows = -1;
        Connection conn = getConnection();
        PreparedStatement ps = null;
        try {
            String sql = "delete from `t_emp` where `emp_id` = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, empId);
            rows = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeAll(null, ps, conn);
        return rows;
    }
}
