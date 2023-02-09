package com.xzy.orm.dao.impl;

import com.xzy.orm.dao.BaseDao;
import com.xzy.orm.dao.IEmpDao;
import com.xzy.orm.entity.Emp;
import com.xzy.orm.util.QueryWrapper;

import java.util.List;

public class EmpDaoImpl extends BaseDao implements IEmpDao {
    @Override
    public int insertEmp(Emp emp) {
        return insert(emp);
    }

    @Override
    public List<Emp> selectList(Emp emp) {
        //打包查询条件
        QueryWrapper qw = null;
        //当emp为null时,不设置任何查询条件
        if (emp != null) {
            qw = new QueryWrapper();
            String empCode = emp.getEmpCode();
            if (empCode != null) {
                qw.eq("emp_code", empCode);
            }
            String empName = emp.getEmpName();
            if (empName != null) {
                qw.eq("emp_name", empName);
            }
            Integer sex = emp.getSex();
            if (sex != null) {
                qw.eq("sex", sex);
            }
            String mobile = emp.getMobile();
            if (mobile != null) {
                qw.eq("mobile", mobile);
            }
            String idCard = emp.getIdCard();
            if (idCard != null) {
                qw.eq("idcard", idCard);
            }
            Integer depId = emp.getDepId();
            if (depId != null) {
                qw.eq("dep_id", depId);
            }
            //按emp_id字段升序
            qw.asc("emp_id");
        }
        List<Object> empList = selectEntityList(Emp.class, qw);
        if (empList == null) {
            //查询异常
            return null;
        } else {
            return (List<Emp>) (List) empList;
        }
    }

    @Override
    public int deleteById(int empId) {
        return deleteEntityById(empId, Emp.class);
    }

    @Override
    public int updateById(Emp emp) {
        return updateEntityById(emp);
    }

    @Override
    public Emp selectById(int empId) {
        return (Emp) selectEntityById(empId, Emp.class);
    }
}
