package com.learning.sb.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class LoggingAspect {

//    This is a regex. it shows in which package and in which class or however we want to point cut and apply logs.
    @Pointcut("execution(* com.learning.sb.service.*.*(..))")
    public void ServiceMethods(){}

//    it will run on every method where point cut applied. Before the execution starts
    @Before("ServiceMethods()")
    public void logBefore(JoinPoint joinPoint){
        log.info("Before Method: {} execution", joinPoint.getSignature().getName());
    }

    //    it will run on every method where point cut applied. After the execution starts
    @After("ServiceMethods()")
    public void logAfter(JoinPoint joinPoint){
        log.info("After Method: {} execution", joinPoint.getSignature().getName());
    }
}
