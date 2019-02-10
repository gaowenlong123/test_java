package com.gao.test;

import com.gao.factory.MyBeanFactory;
import com.gao.model.User;
import com.gao.service.IUserService;
import com.gao.service.StudentService;
import com.gao.web.action.UserAction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

    @Test
    public void test1() throws Exception {

        //自己实现AOP编程，使用JDK代理来实现

        IUserService userService = MyBeanFactory.createUserService();

        userService.deleteUser();
        userService.addUser(100);
        userService.updateUser();

    }

    @Test
    public void test2() throws Exception {

        //实现AOP编程，使用cglib代理来实现

        StudentService ss = MyBeanFactory.createStudentService();

        ss.delete();
       /* ss.update();
        ss.add();*/

    }
}
