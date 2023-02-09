package com.xzy.spring.smvc.service;

import com.xzy.spring.smvc.entity.Emp;

import java.util.List;

public interface IEmpService {
    /**
     * 创建员工
     * @param emp
     * @return
     */
    int createEmp(Emp emp);

    /**
     * 查询员工
     * @return
     */
    List<Emp> selectList();
}
