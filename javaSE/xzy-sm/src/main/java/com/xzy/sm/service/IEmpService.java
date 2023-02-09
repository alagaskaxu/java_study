package com.xzy.sm.service;

import com.xzy.sm.entity.Emp;

import java.util.List;

/**
 * 员工业务类接口
 */
public interface IEmpService {
    /**
     * 创建员工
     * @param emp
     * @return
     */
    int createEmp(Emp emp);

    /**
     * 根据Id删除员工
     * @param empId
     * @return
     */
    int deleteById(int empId);

    /**
     * 根据id修改员工数据
     * @param emp
     * @return
     */
    int updateById(Emp emp);

    /**
     * 根据id查询
     * @param empId
     * @return
     */
    Emp selectById(int empId);

    /**
     * 根据性别部门查询员工信息
     * @param sex
     * @param depId
     * @return
     */
    List<Emp> selectList(int sex,int depId);

    /**
     * 根据部门ID统计人数
     * @param depId
     * @return
     */
    long selectCount(int depId);

    Emp selectEmpById(int empId);
}
