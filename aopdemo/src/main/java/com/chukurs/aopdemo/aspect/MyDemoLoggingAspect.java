package com.chukurs.aopdemo.aspect;

import com.chukurs.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
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


    @AfterReturning(pointcut = "com.chukurs.aopdemo.aspect.ChukursAOPExpressions.forDAOPackage()", returning = "accounts")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> accounts) {

        System.out.println("\nThis code was ran after returning findAccounts");
        System.out.println("and the deleting the intercepted accounts:");
        accounts.clear();
        System.out.println(accounts);
    }

    @AfterThrowing(pointcut = "com.chukurs.aopdemo.aspect.ChukursAOPExpressions.forDAOPackage()", throwing = "exception")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception) {

        System.out.println("\nTHERE IS AN EXCEPTION! HEEEEEEEEEEEEEEEEEEEEEEEEEEEEElP");
        System.out.println("exc =============================> " + exception.getMessage());
        // System.out.println(exception.getMessage());
    }

    @After("com.chukurs.aopdemo.aspect.ChukursAOPExpressions.forDAOPackage()")
    public void afterFindAccountsAdvice(JoinPoint joinPoint) {
        System.out.println("======================> @After is done");
    }

}
