package com.chukurs.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    @Pointcut("execution(* com.chukurs.aopdemo.dao.*.*(..))")
    private void forDAOPackage() {
    }

    @Before("forDAOPackage()")//using full path due to ultimate version of intellij, narrowing down
    public void beforeAddAccountAdvice() {
        System.out.println("This code was ran before");
    }

}
