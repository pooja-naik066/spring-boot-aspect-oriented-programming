package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;


@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {



    @Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        String method=proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n====>>>> Executing @Around on method "+method);

        long begin=System.currentTimeMillis();

        Object result=null;
        System.out.println("Before try");
        try {
            result=proceedingJoinPoint.proceed();

        } catch (Throwable e) {
            System.out.println(e.getMessage());
          //  throw e;
        }
        System.out.println("After try");
        long end=System.currentTimeMillis();

        long duration=end-begin;

        System.out.println("\n=====>>>>Duration "+duration/1000.0 +" seconds");

        return  result;
    }




    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint){
        String method=joinPoint.getSignature().toShortString();
        System.out.println("\n====>>>> Executing @After(finally) on method "+method);

    }

    @AfterThrowing(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint ,Throwable theExc){

        String method=joinPoint.getSignature().toShortString();
        System.out.println("\n====>>>> Executing @AfterThrowing on method "+method);

        System.out.println("\n====>>>> THE Exception is "+theExc);

    }



    //add a new advice @AfterReturning on the findAccounts method
    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        //print out which method we are advicing on
        String method=joinPoint.getSignature().toShortString();
        System.out.println("\n====>>>> Executing @AfterReturning on method "+method);

        //print results of method call
        System.out.println("\n====>>>> result is "+result);

        //post-process the data
        //convert the account name to upper case

        convertAccountNameToUpperCase(result);

      System.out.println("\n====>>>> result is "+result);

    }

    private void convertAccountNameToUpperCase(List<Account> result) {

        //loop through accounts
        for(Account account: result) {

            //get uppercase version of name
            String upperName = account.getName().toUpperCase();

            //update the name on the account
            account.setName(upperName);
        }

    }


    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDAOPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint){
        System.out.println("\n======>>>>> Executing logging");

//        //display the method signature
//        MethodSignature methodSignature=(MethodSignature) joinPoint.getSignature();
//        System.out.println("Method: "+methodSignature);
//
//        //display method arguments
//
//        //get arguments
//        Object[] args=joinPoint.getArgs();
//
//        //loop through args
//        for(Object tempArg:args){
//            System.out.println(tempArg);
//
//        if(tempArg instanceof Account){
//            //downcast and print Account specific stuff
//            Account account=(Account) tempArg;
//            System.out.println("account name "+account.getName());
//            System.out.println("account level "+account.getLevel());
       // }
       // }

    }







}
