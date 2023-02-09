package com.xzy.spring.ioc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Car {
    /**
     * 名字
     */
    private String name;
    /**
     * 颜色
     */
    private String color;
}
