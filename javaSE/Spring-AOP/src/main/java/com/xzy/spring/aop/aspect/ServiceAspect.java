package com.xzy.spring.aop.aspect;

import com.xzy.spring.aop.entity.SysLog;
import com.xzy.spring.aop.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 切面类
 */
@Component("serviceAspect")
@Aspect
public class ServiceAspect {
    @Autowired
    private ISysLogService sysLogService;
    //注解配置切点
    @Pointcut("execution(* com.xzy.spring.aop.service.*.*(..)) && !execution(* com.xzy.spring.aop.service.ISysLogService.*(..))")
    public void pc(){
        //注解切点配置的载体
    }
    /**
     * 当业务执行后(未发送异常),调用该方法
     */
    @AfterReturning("pc()")
    public void afterReturning(JoinPoint jp){
        //业务方法的名称
        String methodName = jp.getSignature().getName();
        //业务类的类名
        String className = jp.getTarget().getClass().getName();
        SysLog log = new SysLog();
        log.setLogType(1);
        log.setCallTime(new Date());
        log.setMethodName(methodName);
        log.setClassName(className);
        sysLogService.createSysLog(log);
    }

    /**
     * 当业务方法发送异常时,调用该方法
     * @param jp
     * @param e
     */
    @AfterThrowing(value = "pc()",throwing = "e")
    public void afterThrows(JoinPoint jp,Throwable e){
        //业务方法的名称
        String methodName = jp.getSignature().getName();
        //业务类的类名
        String className = jp.getTarget().getClass().getName();
        //异常类型
        String exceptionName = e.getClass().getName();
        //异常消息
        String message = e.getMessage();
        message = message==null?"无":message;
        SysLog log = new SysLog();
        log.setLogType(2);
        log.setCallTime(new Date());
        log.setMethodName(methodName);
        log.setClassName(className);
        log.setExceptionName(exceptionName);
        log.setMessage(message);
        sysLogService.createSysLog(log);
    }

    /**
     * 包围增强或通知,可以阻止目标对象中方法的调用或执行
     * @param pjp
     */
    @Around("pc()")
    public Object aroundServiceMethod(ProceedingJoinPoint pjp) throws Throwable
    {
        String methodName =  pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().getName();
        String fullMethodName = className+"."+methodName+"()";
        System.out.println(fullMethodName+"即将被调用");
        long time = System.currentTimeMillis();
        //调用(执行)目标对象中的方法
        Object result = pjp.proceed();
        long x = System.currentTimeMillis()-time;
        //方法调用后,统计一下目标对象的方法调用时所花的时间(毫秒)
        System.out.println(fullMethodName+"执行完成,共消耗:"+x+"毫秒");
        return result;
    }
}
