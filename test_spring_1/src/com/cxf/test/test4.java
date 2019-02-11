package com.cxf.test;

import com.cxf.dao.IUserDao;
import com.cxf.model.User;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class test4 {

    /* 需要导包
    com.springsource.org.apache.commons.dbcp-1.2.2.osgi.jar
     com.springsource.org.apache.commons.pool-1.5.3.jar
     com.springsource.com.mchange.v2.c3p0-0.9.1.2.jar
     mysql-connector-java-5.0.8-bin.jar
     */
    @Test
    public void test1() throws Exception {

       //1.创建数据源
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/testmvc");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        //2.创建jdbcTemplate
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update("update t_user set username = ? where id = ?","gao11",1);


    }

    /* 让 AOP创建数据源   */
    @Test
    public void test2() throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans13.xml");
        IUserDao userDao = (IUserDao) context.getBean("userDao");
        User user = new User();
        user.setUsername("gao");
        user.setPassword("12345");
        userDao.add(user);
    }
}
