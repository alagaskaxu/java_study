package com.xzy.javase.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})
public @interface WebServlet {
    /**
     * 名字
     * @return
     */
    String name() default "";

    /**
     * 启动方式
     * @return
     */
    int loadOnStarUp() default -1;

    /**
     * URL
     * @return
     */
    String value();
}
