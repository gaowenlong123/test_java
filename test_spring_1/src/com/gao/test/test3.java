package com.gao.test;

import com.gao.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2019/2/10 0010.
 */
public class test3 {

    @Test
    public void test1() throws Exception {

        /**
         * 使用注解来配置AOP
         */
        ApplicationContext context = new ClassPathXmlApplicationContext("beans12.xml");

        IUserService userService = (IUserService) context.getBean("userServiceA");

        userService.addUser(100);
    }
}
