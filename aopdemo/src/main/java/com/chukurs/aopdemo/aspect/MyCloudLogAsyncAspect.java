package com.chukurs.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-5)
public class MyCloudLogAsyncAspect {

    @Before("com.chukurs.aopdemo.aspect.ChukursAOPExpressions.forDAOPackage()")
    public void logToCloudAsync() {
        System.out.println("\nThis code logToCloudAsync");
    }

}
