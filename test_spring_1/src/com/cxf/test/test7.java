package com.cxf.test;

import com.cxf.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test7{


    //手动管理事务 ， 就是手动配置事务模板，这个是底层，可以通过代理工厂来实现。
    @Test
    public void test1(){

        //转帐测试
        //获取Service
        ApplicationContext context = new ClassPathXmlApplicationContext("beans15.xml");
        IAccountService accountService = (IAccountService) context.getBean("accountService");
        accountService.transfer("wang","li",100);
    }

    //通过工厂bean 来实现半自动化
    @Test
    public void test2(){

        //转帐测试
        //获取Service
        ApplicationContext context = new ClassPathXmlApplicationContext("beans16.xml");

        //获取service代理对象
        IAccountService accountService = (IAccountService) context.getBean("proxyService");
        accountService.transfer("wang","li",100);
    }

    //基于AOP标签的自动化配置
    @Test
    public void test3(){

        //转帐测试
        //获取Service
        ApplicationContext context = new ClassPathXmlApplicationContext("beans17.xml");

        //获取service代理对象
        IAccountService accountService = (IAccountService) context.getBean("accountService");
        accountService.transfer("wang","li",100);
    }


    //基于注解的事务 配置
    @Test
    public void test4(){

        //转帐测试
        //获取Service
        ApplicationContext context = new ClassPathXmlApplicationContext("beans18.xml");

        //获取service代理对象
        IAccountService accountService = (IAccountService) context.getBean("accountService");
        accountService.transfer("wang","li",100);
    }


}
