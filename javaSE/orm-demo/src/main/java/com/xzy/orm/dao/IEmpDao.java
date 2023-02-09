package com.xzy.orm.dao;

import com.xzy.orm.entity.Emp;

import java.util.List;

public interface IEmpDao {
    /**
     * 创建员工
     *
     * @param emp
     * @return
     */
    int insertEmp(Emp emp);
    /**
     * 根据ID删除员工;
     *
     * @param empId
     * @return
     */
    int deleteById(int empId);

    /**
     * 根据ID修改
     *
     * @param emp
     * @return
     */
    int updateById(Emp emp);

    /**
     * 根据ID查询
     *
     * @param empId
     * @return
     */
    Emp selectById(int empId);

    /**
     * 条件查询员工
     *
     * @param emp
     * @return
     */
    List<Emp> selectList(Emp emp);
}
