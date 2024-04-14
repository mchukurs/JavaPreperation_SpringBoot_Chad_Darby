package com.chukurs.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component

public class MyDemoLoggingAspect {


    @Before("com.chukurs.aopdemo.aspect.ChukursAOPExpressions.forDAOPackage()s")//using full path due to ultimate version of intellij, narrowing down
    public void beforeAddAccountAdvice() {
        System.out.println("\nThis code was ran before non boiler");
    }





}
