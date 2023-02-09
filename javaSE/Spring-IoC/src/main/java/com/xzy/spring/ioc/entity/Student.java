package com.xzy.spring.ioc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    /**
     * 学生ID
     */
    private Integer stuId;
    /**
     * 学号
     */
    private String stuNo;
    /**
     * 出生年月
     */
    private Date birthday;
    /***
     * 姓名
     */
    private String name;
    /**
     * 性别(1:男;2:女)
     */
    private Integer sex;

    /**
     * 教育经历
     */
    private String[] edus;
    /**
     * 爱好
     */
    private List<String> hobbyList;
    /**
     * 家庭成员
     */
    private Set<String> familySet;
    /**
     * 工作经历
     */
    private Map<Long, String> jobMap;
    /**
     * 去过的城市
     */
    private Properties cityProps;
    /**
     * 所属班级
     */
    private Clas clas;
}
