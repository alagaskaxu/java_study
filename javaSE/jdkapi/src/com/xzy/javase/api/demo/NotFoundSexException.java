package com.xzy.javase.api.demo;

/**
 * 自定义 异常
 * 在实际中可以自己写一个 符合自己项目的异常
 * 类名格式:XXXException
 * 只要根据异常想要编译异常还是运行时异常  选择继承Exception或者RuntimeException
 */
public class NotFoundSexException extends Exception{
    /**
     * 1. 继承对应异常的类,自定义类名最后加Exception
     * 2. 生成父类的所有构造器
     */
    public NotFoundSexException() {
    }

    public NotFoundSexException(String message) {
        super(message);
    }

    public NotFoundSexException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundSexException(Throwable cause) {
        super(cause);
    }

    public NotFoundSexException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
