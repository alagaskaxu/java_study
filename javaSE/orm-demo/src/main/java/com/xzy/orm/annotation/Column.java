package com.xzy.orm.annotation;

import java.lang.annotation.*;

/**
 * 配置属性与字段映射关系
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
    /**
     * 字段名称
     * @return
     */
    String name ();

    /**
     * 是否为主键
     * @return
     */
    boolean isPK () default false;

    /**
     * 是否为主键自增长
     * @return
     */
    boolean auto () default false;
}
