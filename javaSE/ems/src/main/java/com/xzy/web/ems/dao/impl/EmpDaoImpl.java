package com.xzy.web.ems.dao.impl;

import cn.hutool.core.util.StrUtil;
import com.xzy.web.ems.dao.BaseDao;
import com.xzy.web.ems.dao.IEmpDao;
import com.xzy.web.ems.entity.Emp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 员工DAO接口实现类
 */
public class EmpDaoImpl extends BaseDao implements IEmpDao {
    @Override
    public int insertEmp(Emp emp) {
        String sql = "insert into `t_emp` (`emp_code`, `emp_name`, `sex`, `idcard`, `mobile`, `birthday`, `money`, `dep_id`) values (?,?,?,?,?,?,?,?)";
        List<Object> paramList = new ArrayList<>();
        paramList.add(emp.getEmpCode());
        paramList.add(emp.getEmpName());
        paramList.add(emp.getSex());
        paramList.add(emp.getIdCard());
        paramList.add(emp.getMobile());
        paramList.add(emp.getBirthday());
        paramList.add(emp.getMoney());
        paramList.add(emp.getDepId());

        return executeUpdate(sql, paramList.toArray());
    }

    @Override
    public int deleteById(int empId) {
        String sql="delete from `t_emp` where `emp_id`=?";
        return executeUpdate(sql,empId);
    }

    @Override
    public int updateById(Emp emp) {
        //占位符所对应的参数值列表
        List<Object> paramList = new ArrayList<>();
        StringBuffer sqlBuf = new StringBuffer();
        sqlBuf.append("update `t_emp` set");
        //如果属性值不为null,说明被修改,则需要更新字段的值
        String empCode = emp.getEmpCode();
        if (empCode != null) {
            sqlBuf.append(" `emp_code`=?,");
            paramList.add(empCode);
        }
        String empName = emp.getEmpName();
        if (empName != null) {
            sqlBuf.append(" `emp_name`=?,");
            paramList.add(empName);
        }
        Integer sex = emp.getSex();
        if (sex != null) {
            sqlBuf.append(" `sex`=?,");
            paramList.add(sex);
        }
        String mobile = emp.getMobile();
        if (mobile != null) {
            sqlBuf.append(" `mobile`=?,");
            paramList.add(mobile);
        }
        String idCard = emp.getIdCard();
        if (idCard != null) {
            sqlBuf.append(" `idcard`=?,");
            paramList.add(idCard);
        }
        Integer money = emp.getMoney();
        if (money != null) {
            sqlBuf.append(" `money`=?,");
            paramList.add(money);
        }
        Integer depId = emp.getDepId();
        if (depId != null) {
            sqlBuf.append(" `dep_id`=?,");
            paramList.add(depId);
        }
        Date birthday = emp.getBirthday();
        if (birthday != null) {
            sqlBuf.append(" `birthday`=?,");
            paramList.add(birthday);
        }
        //删除最后一个逗号(,)
        sqlBuf.deleteCharAt(sqlBuf.length() - 1);
        sqlBuf.append(" where `emp_id`=?");
        paramList.add(emp.getEmpId());
        String sql = sqlBuf.toString();
        System.out.println(sql);
        //执行修改
        return executeUpdate(sql, paramList.toArray());
    }

    @Override
    public List<Emp> selectList(Emp emp) {
        List<Emp> empList = new ArrayList<>();
        Connection conn = getConnection();
        Statement s = null;
        ResultSet rs = null;
        try {
            //拼接SQL
            StringBuffer sqlBuf = new StringBuffer();
            sqlBuf.append("select `emp_id`, `emp_code`, `emp_name`, `sex`, `idcard`, `mobile`, `birthday`, `money`, `dep_id` from `t_emp` where 1=1");
            if (emp != null) {
                String empCode = emp.getEmpCode();
                //if (empCode!=null&&!empCode.isEmpty())
                if (StrUtil.isNotEmpty(empCode)) {
                    //添加员工编号
                    sqlBuf.append(" and `emp_code`='" + empCode + "'");
                }
                String empName = emp.getEmpName();
                if (StrUtil.isNotEmpty(empName)) {
                    //添加员工姓名
                    sqlBuf.append(" and `emp_name`='" + empName + "'");
                }
                String mobile = emp.getMobile();
                if (StrUtil.isNotEmpty(mobile)) {
                    //添加员工手机号
                    sqlBuf.append(" and `mobile`='" + mobile + "'");
                }
                String idcard = emp.getIdCard();
                if (StrUtil.isNotEmpty(idcard)) {
                    //添加员工身份证号
                    sqlBuf.append(" and `idcard`='" + idcard + "'");
                }
                Integer depId = emp.getDepId();
                if (depId != null) {
                    sqlBuf.append(" and `dep_id`=" + depId);
                }
                Integer sex = emp.getSex();
                if (sex != null) {
                    sqlBuf.append(" and `sex`=" + sex);
                }
            }
            String sql = sqlBuf.toString();
            s = conn.createStatement();
            rs = s.executeQuery(sql);
            while (rs.next()) {
                Emp empEntity = new Emp();
                empEntity.setEmpId(rs.getInt("emp_id"));
                empEntity.setEmpCode(rs.getString("emp_code"));
                empEntity.setEmpName(rs.getString("emp_name"));
                empEntity.setSex(rs.getInt("sex"));
                empEntity.setIdCard(rs.getString("idcard"));
                empEntity.setBirthday(rs.getDate("birthday"));
                empEntity.setMobile(rs.getString("mobile"));
                empEntity.setMoney(rs.getInt("money"));
                empEntity.setDepId(rs.getInt("dep_id"));
                empList.add(empEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            empList = null;
        }
        closeAll(rs, s, conn);
        return empList;
    }

    @Override
    public Emp selectById(int empId) {
        String sql = "select `emp_id`, `emp_code`, `emp_name`, `sex`, `idcard`, `mobile`, `birthday`, `money`, `dep_id` from `t_emp` where `emp_id`=?";
        Emp emp = (Emp)selectById(sql,empId,Emp.class);
        return emp;
    }
}
