package com.chukurs.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ChukursAOPExpressions {
    @Pointcut("execution(* com.chukurs.aopdemo.dao.*.*(..))")
    private void forDAOPackage() {
    }


    @Pointcut("execution(* com.chukurs.aopdemo.dao.*.get*(..))")
    public void getter() {
    }

    @Pointcut("execution(* com.chukurs.aopdemo.dao.*.set*(..))")
    public void setter() {
    }


    @Pointcut(" forDAOPackage()  &&  !( getter() || setter() )")
    public void forDAOPackageExcludingBoiler() {
    }


}
