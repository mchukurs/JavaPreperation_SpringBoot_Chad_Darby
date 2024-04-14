package com.chukurs.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyCloudLogAsyncAspect {
    @Before("forDAOPackageExcludingBoiler()")
    public void logToCloudAsync() {
        System.out.println("\nThis code logToCloudAsync");
    }

}
