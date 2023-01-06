package com.xzy.jdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 部门实体类
 */
@Data   //lombok插件自动生产get,set方法
@NoArgsConstructor  //自动生成无参构造器
@AllArgsConstructor //自动生成所有有参构造方法
@ToString()
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

}
