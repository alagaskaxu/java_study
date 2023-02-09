package com.xzy.spring.smvc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xzy.spring.smvc.entity.Emp;
import com.xzy.spring.smvc.mapper.EmpMapper;
import com.xzy.spring.smvc.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("empService")
public class EmpServiceImpl implements IEmpService {
    @Autowired
    private EmpMapper empMapper;
    @Override
    public int createEmp(Emp emp) {
        return empMapper.insert(emp);
    }

    @Override
    public List<Emp> selectList() {
        QueryWrapper<Emp> qw = new QueryWrapper();
        return empMapper.selectList(qw);
    }
}
