package com.xzy.web.ems.entity;

import com.alibaba.fastjson.annotation.JSONField;
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
public class Emp {
    /**
     * 员工ID
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
     * 性别(1:男;2:女)
     */
    private Integer sex;
    /**
     * 身份证号码
     */
    private String idCard;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 出生日期
     */
    @JSONField(format = "yyyy-MM-dd")
    private Date birthday;
    /**
     * 部门ID
     */
    private Integer depId;
    /**
     * 薪水
     */
    private Integer money;

    /**
     * 员工所属部门
     */
    private Dep dep;
}
