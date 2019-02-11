package com.cxf.test.day1;

import com.cxf.model.Programmer;
import com.cxf.model.User;
import com.cxf.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2019/2/9 0009.
 */
public class test3 {
    @Test
    public void test1() throws Exception {


        /**
         * Bean的集合注入
         */
        ApplicationContext context = new ClassPathXmlApplicationContext("beans6.xml");

        Programmer programmer  = (Programmer) context.getBean("programmer");

        System.out.println("车:" + programmer.getCars());
        System.out.println("宠物:" + programmer.getPats());
        System.out.println("个人信息:" + programmer.getInfos());
        System.out.println("数据库连接信息:" + programmer.getMysqlInfos());
        System.out.println("家庭成员:");
        for (String member : programmer.getMembers()){
            System.out.println(member);
        }
    }

    @Test
    public void test2() throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans7.xml");

        //第一种
        /*
        1.如果是@Component()   没配置id,通过类型获取
        IUserService service = (IUserService) context.getBean(IUserServiceImpl.class);
        2.这个类型可以是接口，还可以是实现类
        IUserService service = (IUserService) context.getBean(IUserService.class);
         */

        //第二种
        //如果@Component("userService123"),配置了id，就可以通过id来获取
        IUserService service = (IUserService) context.getBean("userService123");


        User user = new User();
        user.setUsername("gao");

        service.add(user);
    }
}
