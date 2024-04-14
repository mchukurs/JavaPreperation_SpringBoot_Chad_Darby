package com.chukurs.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyApiAnalyticsAspect {


    @Before("com.chukurs.aopdemo.aspect.MyDemoLoggingAspect.forDAOPackageExcludingBoiler()")
    public void performingApiAnalytics() {
        System.out.println("\nThis code performingApiAnalytics");
    }
}
