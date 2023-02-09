package com.xzy.mybatis.dao;

import com.xzy.mybatis.entity.Emp;

public interface IEmpDao {

    /**
     * 创建员工
     * @param emp
     * @return
     */
    int insertEmp(Emp emp);

    /**
     * 删除员工
     * @param empId
     * @return
     */
    int deleteById(int empId);

    /**
     * 根据ID修改员工
     * @param emp
     * @return
     */
    int updateById(Emp emp);
    /**
     * 根据ID查询员工
     * @param empId
     * @return
     */
    Emp selectById(int empId);
}
