package com.xzy.sm.entity;

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
//orm映射关系注解,实体类与表的映射关系
@TableName("t_emp")
//注解mybatis实体类别名
@Alias("emp")
public class Emp {
    /**
     * 员工id
     */
    @TableId(type = IdType.AUTO)    //主键必须配TableId注解,(主键自动增长)
    @TableField("emp_id")   //可手动对应,也可以知道转换对应,属性驼峰自动转字段下划线_,没驼峰就保持一致
    private Integer empId;
    /**
     * 员工编号
     */
    @TableField("emp_code")
    private String empCode;
    /**
     * 员工姓名
     */
    private String empName;
    /**
     * 员工性别
     */
    @TableField("sex")
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
    /**
     * 所属部门,无需映射表中的字段,exist = false,不存在映射关系
     */
    @TableField(exist = false)
    private Dep dep;
}
