package com.xzy.sm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xzy.sm.entity.Emp;
import com.xzy.sm.mapper.EmpMapper;
import com.xzy.sm.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("empService")
public class EmpServiceImpl implements IEmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int createEmp(Emp emp) {
        int rows = empMapper.insert(emp);
        return rows;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int deleteById(int empId) {
        return empMapper.deleteById(empId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int updateById(Emp emp) {
        return empMapper.updateById(emp);
    }

    @Override
    //@Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public Emp selectById(int empId) {
        return empMapper.selectById(empId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public List<Emp> selectList(int sex, int depId) {
        QueryWrapper<Emp> qw = new QueryWrapper<>();
        //打包查询条件
        qw.eq("sex",sex);
        qw.eq("dep_id",depId);
        //根据money字段降序
        qw.orderByDesc("money");
        return empMapper.selectList(qw);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public long selectCount(int depId) {
        QueryWrapper<Emp> qw = new QueryWrapper<>();
        qw.eq("dep_id",depId);
        return empMapper.selectCount(qw);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Emp selectEmpById(int empId) {
        return empMapper.selectEmpById(empId);
    }
}
