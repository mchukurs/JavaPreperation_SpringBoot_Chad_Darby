package com.chukurs.aopdemo.aspect;

import com.chukurs.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(-6)
public class MyDemoLoggingAspect {

    @Order(-5)
    @Before("com.chukurs.aopdemo.aspect.ChukursAOPExpressions.forDAOPackage()")
//using full path due to ultimate version of intellij, narrowing down
    public void beforeAddAccountAdvice() {
        System.out.println("\nThis code was ran before non boiler");
    }

    @Order(-100)
    @AfterReturning(pointcut = "com.chukurs.aopdemo.aspect.ChukursAOPExpressions.forDAOPackage()", returning = "accounts")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> accounts) {

        System.out.println("\nThis code was ran after returning findAccounts");
        System.out.println("and the following accounts:");
        System.out.println(accounts);
    }

}
