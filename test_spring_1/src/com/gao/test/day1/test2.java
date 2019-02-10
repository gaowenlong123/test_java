package com.gao.test.day1;

import com.gao.model.Customer;
import com.gao.model.Student;
import com.gao.model.User;
import com.gao.service.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class test2 {

    //作用域
    @Test
    public void test1(){

        ApplicationContext context = new ClassPathXmlApplicationContext("beans3.xml");

        //从容器获取两个bean
        IUserService userService1 = (IUserService) context.getBean("userService");
        IUserService userService2 = (IUserService) context.getBean("userService");

        System.out.println(userService1);
        System.out.println(userService2);


    }


    //Bean的生命周期
    @Test
    public void test2() throws Exception {


        ApplicationContext context = new ClassPathXmlApplicationContext("beans3.xml");

        User user = (User) context.getBean("user");

        System.out.println("调用Bean对象 ：  "+user);


        //关闭容器
        context.getClass().getMethod("close").invoke(context);
    }

    //注意 java 1.8 和spring 4.0+ 兼容
    @Test
    public void test3() throws Exception {
        //给对象的属性赋值方式
        /**
         * 1.构造方法注入
         */
        ApplicationContext context = new ClassPathXmlApplicationContext("beans4.xml");

        Student stu  = (Student) context.getBean("stu");


        System.out.println(stu);
    }


    //SpEL:spring表达式
    @Test
    public void test4() throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans5.xml");

        Customer customer  = (Customer) context.getBean("customer");
        System.out.println(customer);

        System.out.println(customer.getAddress());
    }

}