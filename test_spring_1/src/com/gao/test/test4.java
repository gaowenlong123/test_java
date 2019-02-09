package com.gao.test;

import com.gao.model.User;
import com.gao.service.IUserService;
import com.gao.web.action.UserAction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * 在写web程序的时候 ：需要 action 调用service 再调用 dao层
 *
 * UserAction  =》 UserActionServiceImpl  =》 UserDaoImpl
 *
 *
 * Created by Administrator on 2019/2/9 0009.
 */
public class test4 {

    //使用注解将下面的简化
    @Test
    public void test() throws Exception {

        //注解的使用
        //web开发流程 action -> service -> dao
        ApplicationContext context = new ClassPathXmlApplicationContext("beans7.xml");


        //获取action
//        UserAction userAction =  context.getBean(UserAction.class);
        UserAction userAction = (UserAction) context.getBean("myAction");
        UserAction userAction2 = (UserAction) context.getBean("myAction");

        //添加用户
        User user = new User();
        user.setUsername("gao");
        user.setPassword("1234");
        userAction.save(user);

        System.out.println(userAction);
        System.out.println(userAction2);

        //关闭容器  通过反射
        context.getClass().getMethod("close").invoke(context);

    }


    @Test
    public void  test1() throws Exception {


        //注解的使用
        //web开发流程  service -> dao

        ApplicationContext context = new ClassPathXmlApplicationContext("beans8.xml");
        //拿到service
        IUserService userService = (IUserService) context.getBean("userService");

        //添加用户
        User user = new User();
        user.setUsername("gao");
        user.setPassword("1234");
        userService.add(user);
    }

    @Test
    public void test2() throws Exception {

        //注解的使用
        //web开发流程 action -> service -> dao

        ApplicationContext context = new ClassPathXmlApplicationContext("beans8.xml");

        //拿到action
        UserAction userAction = (UserAction) context.getBean("userAction");

        //添加用户
        User user = new User();
        user.setUsername("gyf");
        user.setPassword("1234");
        userAction.save(user);

    }



}
