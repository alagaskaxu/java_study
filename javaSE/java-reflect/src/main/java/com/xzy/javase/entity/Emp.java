package com.xzy.javase.entity;

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
public class Emp implements IEmp{
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
     * 设置部门ID
     * @param i  参数1
     * @param j  参数2
     */
    private void setDepId(Integer i,Integer j){
        System.out.println("i="+i);
        System.out.println("j="+j);
        System.out.println("setDepId(Integer i,Integer j)");
    }
    public void setDepId(){
        System.out.println("setDepId()");
    }


    }
