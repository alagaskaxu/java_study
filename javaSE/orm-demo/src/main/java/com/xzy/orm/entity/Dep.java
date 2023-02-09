package com.xzy.orm.entity;

import com.xzy.orm.annotation.Column;
import com.xzy.orm.annotation.Table;
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
@Table(name="t_dep")
public class Dep {
    /**
     * 部门ID
     */
    @Column(name="dep_id",isPK = true,auto = true)
    private Integer depId;
    /**
     * 部门编号
     */
    @Column(name="dep_code")
    private String depCode;
    /**
     * 部门名称
     */
    @Column(name="dep_name")
    private String depName;
    /**
     * 部门状态
     */
    @Column(name="dep_state")
    private Integer depState;

}
