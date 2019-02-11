package com.cxf.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 *
 *  AOP联盟 特殊的接口，必须实现 ，从而确定方法名称
 *
 */
public class MyAspect1 implements MethodInterceptor{

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        //拦截方法

        System.out.println("开启事务...");


        //放行
        Object retObj = mi.proceed();

        System.out.println("拦截.....");

        System.out.println("提交事务...");

        return retObj;
    }
}
