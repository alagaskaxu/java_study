package com.xzy.orm.entity;

import com.xzy.orm.annotation.Column;
import com.xzy.orm.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * 员工实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "t_emp")
public class Emp {
    /**
     * 员工ID
     */
    @Column(name = "emp_id", isPK = true,auto = true)
    private Integer empId;
    /**
     * 员工编号
     */
    @Column(name = "emp_code")
    private String empCode;
    /**
     * 员工姓名
     */
    @Column(name = "emp_Name")
    private String empName;
    /**
     * 性别(1:男;2:女)
     */
    @Column(name = "sex")
    private Integer sex;
    /**
     * 身份证号码
     */
    @Column(name = "idcard")
    private String idCard;
    /**
     * 手机号码
     */
    @Column(name = "mobile")
    private String mobile;
    /**
     * 出生日期
     */
    @Column(name = "birthday")
    private Date birthday;
    /**
     * 部门ID
     */
    @Column(name = "dep_id")
    private Integer depId;
    /**
     * 薪水
     */
    @Column(name = "money")
    private Integer money;

}
