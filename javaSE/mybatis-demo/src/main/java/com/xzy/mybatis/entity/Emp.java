package com.xzy.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * 员工实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
//自定义别名,注解方式
@Alias("emp")
public class Emp {
    /**
     * 员工id
     */
    private Integer empId;
    /**
     * 员工编号
     */
    private String empCode;
    /**
     * 员工姓名
     */
    private String empName;
    /**
     * 员工性别
     */
    private Integer sex;
    /**
     * 员工身份证
     */
    private String idCard;
    /**
     * 员工手机号
     */
    private String mobile;
    /**
     * 员工生日
     */
    private Date birthday;
    /**
     * 员工月薪
     */
    private Integer money;
    /**
     * 部门Id
     */
    private Integer depId;
    /**
     * 所属部门,用于两个表的关联查询
     */
    private Dep dep;
}
