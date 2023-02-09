package com.xzy.spring.ioc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Clas {
    /**
     * 班级ID
     */
    private Integer classId;
    /**
     * 班级名称
     */
    private String className;
    /**
     * 班级编号
     */
    private String classNo;
}
