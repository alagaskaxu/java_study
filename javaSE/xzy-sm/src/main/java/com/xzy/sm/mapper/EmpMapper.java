package com.xzy.sm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xzy.sm.entity.Emp;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpMapper extends BaseMapper<Emp> {
    /**
     * 根据员工ID查询员工信息,同时关联查询员工所属部门的信息
     * @param empId
     * @return
     */
    Emp selectEmpById(int empId);
}
