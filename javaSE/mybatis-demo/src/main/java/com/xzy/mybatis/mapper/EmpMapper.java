package com.xzy.mybatis.mapper;

import com.xzy.mybatis.entity.Emp;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 员工Mapper接口
 */
public interface EmpMapper {
    /**
     * 根据性别状态,部门Id查询部门列表
     * SQL语句ID:com.xzy.mybatis.mapper.EmpMapper.selectList
     *
     * @param sex
     * @param depId
     * @return
     */
    //@Select("select `emp_id` as empId, `emp_code` as empCode, `emp_name` as empName, `sex`, `idcard`, `mobile`, `birthday`, `money`, `dep_id` as depId from `t_emp` where `sex`=#{sex} and `dep_id`=#{dep_id}")
    //xml+注解方式
    List<Emp> selectList(@Param("sex") int sex, @Param("dep_id") int depId);

    List<Emp> selectListByEmp(Emp emp);

    /**
     * 根据部门Id查询员工
     * @param depId
     * @return
     */
    List<Emp> selectListByDepId(@Param("dep_id") int depId);


    /**
     * 添加员工信息
     * SQL语句ID:com.xzy.mybatis.mapper.EmpMapper.insertEmp
     *
     * @param emp
     * @return
     */
    //@Insert("insert into `t_emp` (`emp_code`, `emp_name`, `sex`, `idcard`, `mobile`, `birthday`, `money`, `dep_id`) values (#{empCode}, #{empName}, #{sex}, #{idCard}, #{mobile}, #{birthday}, #{money}, #{depId})")
    int insertEmp(Emp emp);

    /**
     * 通过Id查询员工
     * @param empId
     * @return
     */
    Emp selectById(int empId);

    //纯注解方法,纯注解方式要在MyBatis-config.xml中配置Mapper接口的类路径

    /**
     * 根据ID删除员工信息
     *
     * @param empId
     * @return
     */
    @Delete("delete from `t_emp` where `emp_id` = #{empId}")
    int deleteById(@Param("empId") int empId);

    /**
     * 根据id修改员工月薪
     *
     * @param emp
     * @return
     */
    @Update("update `t_emp` set `money` = #{money} where `emp_id` = #{empId};")
    int updateById(Emp emp);

    /**
     * map传参,根据id修改员工月薪,手机号
     * @param paramMap
     * @return
     */
    int updateByMap(Map<String,Object> paramMap);

}
