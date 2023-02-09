package com.xzy.spring.smvc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("t_emp")
@Alias("emp")
public class Emp {
    /**
     * 员工id
     */
    @TableId(type = IdType.AUTO)
    @TableField("emp_id")
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
    @TableField("idcard")
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
}
