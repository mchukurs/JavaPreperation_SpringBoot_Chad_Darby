package com.chukurs.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    @Before("execution(* com.chukurs.aopdemo..add*(..))")//using full path due to ultimate version of intellij, narrowing down
    public void beforeAddAccountAdvice() {
        System.out.println("This code was ran before");
    }

}
