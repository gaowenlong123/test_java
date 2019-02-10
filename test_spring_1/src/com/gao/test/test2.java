package com.gao.test;

import com.gao.service.IUserService;
import com.gao.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class test2 {


    /**
     * 1： spring编写代理半自动
     *              1： 导入jar包
     *              2： 目标类
     *              3： 切面类    将增强代码和 切入点结合 。 不需要bean工厂
     *              4： spring配置
     *              5： 测试
     */
    @Test
    public void test1() throws Exception {

        //获取Spring容器中代理对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans9.xml");

        //只需要代理对象就行
        IUserService userService = (IUserService) context.getBean("serviceProxy");

        userService.deleteUser();

    }

    //全自动 ，但是还要自己写切面方法 。因为系统不知道你想要执行什么方法    。 需要导包 aspectj.weaver.jar
    /*用于 事务配置 和 日志*/
    @Test
    public void test2() throws Exception {

        //获取Spring容器中代理对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans10.xml");

        //不需要像上面一样拿配置工厂的函数 ，因为已经自动配置了，直接拿方法service就行
        IUserService userService = (IUserService) context.getBean("userService");

        userService.deleteUser();

        StudentService ss = (StudentService) context.getBean("studentService");
        ss.add();

    }

    //切面类 与上面不同 。 不需要继承，自定义 前后通知，进行配置
    @Test
    public void test3() throws Exception {

        //获取Spring容器中代理对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans11.xml");

        IUserService userService = (IUserService) context.getBean("userService");

        userService.addUser(10);



    }

}
