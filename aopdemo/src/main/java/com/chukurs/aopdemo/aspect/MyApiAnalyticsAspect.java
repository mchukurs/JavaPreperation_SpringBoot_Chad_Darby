package com.chukurs.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.weaver.patterns.ArgsPointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Order(-1)
public class MyApiAnalyticsAspect {


    @Before("com.chukurs.aopdemo.aspect.ChukursAOPExpressions.forDAOPackage()")
    public void performingApiAnalytics(JoinPoint theJoinPoint) {

        System.out.println("\nThis code performingApiAnalytics and has JoinPoint with \n");

        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method Signature: "+ methodSignature);

        Object[] args = theJoinPoint.getArgs();
        System.out.println("Arguments: "+ Arrays.toString(args));

    }
}
