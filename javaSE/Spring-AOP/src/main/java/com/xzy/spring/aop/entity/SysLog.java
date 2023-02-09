package com.xzy.spring.aop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Alias("log")
public class SysLog {
    /**
     * 日志ID
     */
    private Integer logId;
    /*
     * 调用方法名
     **/
    private String methodName;
    /**
     * 业务类名称
     */
    private String className;
    /**
     * 调用时间
     */
    private Date callTime;
    /**
     * 日志类型(1:信息;2:异常)
     */
    private Integer logType;
    /**
     * 异常类名
     */
    private String exceptionName;
    /**
     * 异常消息
     */
    private String message;
}
