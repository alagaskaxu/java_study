package com.xzy.spring.ioc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Dep {
    public Dep() {
        System.out.println("+++创建部门+++");
    }

    private String depName;
}
