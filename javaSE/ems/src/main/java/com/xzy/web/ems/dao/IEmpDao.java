package com.xzy.web.ems.dao;

import com.xzy.web.ems.entity.Emp;

import java.util.List;

/**
 * 员工接口
 */
public interface IEmpDao {
    /**
     * 创建员工
     * @param emp
     * @return
     */
    int insertEmp(Emp emp);

    /**
     * 根据员工Id删除员工
     * @param empId
     * @return
     */
    int deleteById(int empId);

    /**
     * 根据员工ID修改数据
     * @param emp
     * @return
     */
    int updateById(Emp emp);
    /**
     * 根据条件查询员工列表数据
     * @param emp
     * @return
     */
    List<Emp> selectList(Emp emp);

    /**
     * 根据员工Id查询员工对象
     * @param empId
     * @return
     */
    Emp selectById(int empId);
}
