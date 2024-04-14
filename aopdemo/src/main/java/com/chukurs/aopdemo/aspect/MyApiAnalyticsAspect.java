package com.chukurs.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-1)
public class MyApiAnalyticsAspect {


    @Before("com.chukurs.aopdemo.aspect.ChukursAOPExpressions.forDAOPackage()")
    public void performingApiAnalytics() {
        System.out.println("\nThis code performingApiAnalytics");
    }
}
