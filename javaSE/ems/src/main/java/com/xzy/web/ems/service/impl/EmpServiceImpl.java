package com.xzy.web.ems.service.impl;

import com.xzy.web.ems.dao.IDepDao;
import com.xzy.web.ems.dao.IEmpDao;
import com.xzy.web.ems.dao.impl.DepDaoImpl;
import com.xzy.web.ems.dao.impl.EmpDaoImpl;
import com.xzy.web.ems.entity.Dep;
import com.xzy.web.ems.entity.Emp;
import com.xzy.web.ems.service.IEmpService;

import java.util.List;

/**
 * 员工service实现类
 */
public class EmpServiceImpl implements IEmpService {
    private IEmpDao empDao = new EmpDaoImpl();
    private IDepDao depDao = new DepDaoImpl();
    @Override
    public int createEmp(Emp emp) {
        return empDao.insertEmp(emp);
    }

    @Override
    public int deleteById(int empId) {
        return empDao.deleteById(empId);
    }

    @Override
    public int updateById(Emp emp) {
        return empDao.updateById(emp);
    }

    @Override
    public Emp selectById(int empId) {
        //查询员工信息
        Emp emp = empDao.selectById(empId);
        //查询员工所属部门信息
        if (emp!=null&&emp.getEmpId()!=null)
        {
            int depId = emp.getDepId();
            Dep dep = depDao.selectById(depId);
            emp.setDep(dep);
        }
        System.out.println(emp);
        return emp;
    }

    @Override
    public List<Emp> selectList(Emp emp) {
        return empDao.selectList(emp);
    }
}
