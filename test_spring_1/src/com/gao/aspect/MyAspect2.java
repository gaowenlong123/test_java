package com.gao.aspect;


import org.aspectj.lang.ProceedingJoinPoint;

/*
aspectj 通知类型 ，只定义类型名称，以及方法格式
1：导入规范     aspectj.weaver-1.6.8.jar
2：自定义方法 ，然后再xml里面配置


*/
public class MyAspect2 {
    public void myBefore(){
        System.out.println("前置通知...");
    }

    public void myAfterReturning(){
        System.out.println("后置通知...");
    }

    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕通知...");

        System.out.println(pjp.getSignature().getName());//切入点就方法名
        System.out.println("开启事务...");

        //放行
        Object retObj = pjp.proceed();

        System.out.println("提交事务...");
        return retObj;
    }
}
