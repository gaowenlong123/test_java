package com.cxf.test.day1;

import com.cxf.service.IUserService;
import com.cxf.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by Administrator on 2019/2/9 0009.
 */
public class test {

    @Test
    public void test1(){

        //以前用userservice的方式
        IUserService userface = new UserServiceImpl();
        userface.add();

        //现在使用UserServiceImpl对象从spring容器里获取
        //加载beans.xml文件               类路径就是在src路径下
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println(context);

        //从spring的这个容器中获取对象
        IUserService userService= (IUserService) context.getBean("userService");
        userService.add();
        IUserService userService2= (IUserService) context.getBean("userService");

        //无论new几次都是同一个ID
        System.out.println(userService);
        System.out.println(userService2);
    }

    @Test
    public void test2(){


/*      BeanFactory 采取延迟加载，第一次getBean时才会初始化Bean
        ApplicationContext 即时加载  。 没有调用也加载类的构造方法
        ApplicationContext是对BeanFactory扩展，提供了更多功能
            国际化处理
            事件传递
            Bean自动装配
            各种不同应用层的Context实现

        */


        //spring 三种 加载方式

        //1：类路径加载配置文件  最常用
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //从spring的这个容器中获取对象
        IUserService userService= (IUserService) context.getBean("userService");
        System.out.println(userService);

        //2：通过文件系统路径
        ApplicationContext context1  = new FileSystemXmlApplicationContext("D:\\JavaProjects\\test_java\\test_spring_1\\src\\beans.xml");
        IUserService userService1= (IUserService) context.getBean("userService");
        System.out.println(userService1);


        //3beanFactory （了解 已过时 ）
//        BeanFactory factory = new XmlBeanFactory();


    }

    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");

        //new 对象
        //IUserService userService1 = (IUserService) context.getBean("userService1");
        //userService1.add();


        //静态工厂
        //IUserService userService2 = UserSereviceFactory1.createUserService();
        //IUserService userService2 = (IUserService) context.getBean("userService2");
        //userService2.add();


        //实例工厂  非静态工厂需要实例化两次
        //1.创建工厂
        // UserSereviceFactory2 factory2 = new UserSereviceFactory2();
        //IUserService userService3 = factory2.createUserService();

        IUserService userService3 = (IUserService) context.getBean("userService3");
        userService3.add();
    }
}
