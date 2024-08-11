package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    public void forDAOPackage(){}

    //create a pointcut for getters and setters
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
    public  void getter() {}

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
    public  void setter() {}

    //create pointcut..include package..exclude getters/setters
    @Pointcut("forDAOPackage() && !(getter() || setter())")
    public void forDAOPackageNoGetterSetter(){}


}
