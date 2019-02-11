package com.cxf.test;

import com.cxf.factory.MyBeanFactory;
import com.cxf.service.IUserService;
import com.cxf.service.StudentService;
import org.junit.Test;

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
