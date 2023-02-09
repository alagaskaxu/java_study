package com.xzy.web.ems.service;

import com.xzy.web.ems.entity.Emp;

import java.util.List;

/**
 * 员工service接口
 */
public interface IEmpService {
    /**
     * 创建员工
     *
     * @param emp
     * @return
     */
    int createEmp(Emp emp);

    /**
     * 根据员工删除
     *
     * @param empId
     * @return
     */
    int deleteById(int empId);

    /**
     * 根据员工Id修改员工数据
     * @param emp
     * @return
     */
    int updateById(Emp emp);

    /**
     * 根据员工Id查询员工数据
     * @param empId
     * @return
     */
    Emp selectById(int empId);

    /**
     * 根据条件查询员工
     * @param emp
     * @return
     */
    List<Emp> selectList(Emp emp);
}
