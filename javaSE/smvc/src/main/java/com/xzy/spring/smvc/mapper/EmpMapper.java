package com.xzy.spring.smvc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xzy.spring.smvc.entity.Emp;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpMapper extends BaseMapper<Emp> {
}
