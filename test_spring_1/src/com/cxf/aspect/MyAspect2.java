package com.cxf.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/*
aspectj 通知类型 ，只定义类型名称，以及方法格式
1：导入规范     aspectj.weaver-1.6.8.jar
2：自定义方法 ，然后再xml里面配置


*/
public class MyAspect2 {
    public void myBefore(JoinPoint joinPoint){
        System.out.println("1:前置通知..." + joinPoint.getSignature().getName());
    }

    //业务方法执行完就会调用 ，但是为什么最后一个调用
    public void myAfterReturning(JoinPoint joinPoint , Object retValue){
        System.out.println("4:后置通知..."+joinPoint.getSignature().getName() +"   返回值..."+ retValue);
    }

    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("2:环绕通知...开启事务...");

        System.out.println(pjp.getSignature().getName());

        //放行
        Object retObj = pjp.proceed();

        System.out.println("3:环绕通知...提交事务...");
        return retObj;
    }

    public void myAfterThrowing(JoinPoint jp,Throwable e){
        System.out.println("异常通知..." + jp.getSignature().getName() + "===" + e.getMessage() );
    }

    public void myAfter(JoinPoint jp){
        System.out.println("最终通知..." + jp.getSignature().getName());
    }
}
