package com.gao.test;

import com.gao.dao.IUserDao;
import com.gao.model.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test6 {

    @Test
    public void test1() throws Exception {

       // 更加简化 让jdbcTemplate自动配置
        ApplicationContext context = new ClassPathXmlApplicationContext("beans14.xml");
        IUserDao userDao = (IUserDao) context.getBean("userDao");
        User user = new User();
        user.setUsername("gao");
        user.setPassword("12366666");
        userDao.add(user);
    }
}
