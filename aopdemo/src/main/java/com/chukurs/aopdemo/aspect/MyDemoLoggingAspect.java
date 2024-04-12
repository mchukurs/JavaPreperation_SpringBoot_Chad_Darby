package com.chukurs.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    @Before("execution(* add*(com.chukurs.aopdemo.Account))")
    public void beforeAddAccountAdvice() {
        System.out.println("This code was ran before");
    }

}
