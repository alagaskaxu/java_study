package com.xzy.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * 部门实体类
 */
@Data   //lombok插件自动生产get,set方法
@NoArgsConstructor  //自动生成无参构造器
@AllArgsConstructor //自动生成所有有参构造方法
@ToString()
//自定义别名,注解方式
@Alias("dep")
public class Dep {
    /**
     * 部门ID
     */
    private Integer depId;
    /**
     * 部门编号
     */
    private String depCode;
    /**
     * 部门名称
     */
    private String depName;
    /**
     * 部门状态
     */
    private Integer depState;

    /**
     * 部门内的所有员工的集合,一对多,用于多表查询
     */
    private List<Emp> empList;

}
