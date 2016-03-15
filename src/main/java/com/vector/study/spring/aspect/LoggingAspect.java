package com.vector.study.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * author: vector.huang
 * date：2016/3/14 15:59
 */
@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(public int com.vector.study.spring.aspect.PersonFuck.add(int,int))")
    public void pointcutExpression(){}

    @Before("pointcutExpression()")
    public void before(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("Then method "+methodName+" begins with " + args);
    }

    @After("execution(public int com.vector.study.spring.aspect.PersonFuck.add(int,int))")
    public void after(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("Then method "+methodName+" end with " + args);
    }


    @AfterReturning(value =  "execution(public int com.vector.study.spring.aspect.PersonFuck.add(int,int))"
                ,returning = "result")
    public void afterReturning(JoinPoint joinPoint,int result){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("Then method "+methodName+" return with " + args + " = " + result);
    }

    @AfterThrowing(value =  "execution(public int com.vector.study.spring.aspect.PersonFuck.add(int,int))"
            ,throwing = "result")
    public void afterThrowing(JoinPoint joinPoint,Exception result){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("Then method "+methodName+" exception with " + args + " = " + result);
    }

    @Around("execution(public int com.vector.study.spring.aspect.PersonFuck.add(int,int))")
    public Object around(ProceedingJoinPoint pjd){
        return 100;
    }
}
