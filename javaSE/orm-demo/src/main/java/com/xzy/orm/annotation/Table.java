package com.xzy.orm.annotation;

import java.lang.annotation.*;

/**
 * 数据库表注解
 * 配置实体类与数据库表映射关系
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
    /**
     * 表名
     * @return
     */
    String name ();

}
