package com.gao.test;

import com.gao.mapper.UserMapper;
import com.gao.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/*
* 经常用这个  ，通过  mapper代理方式实现
*
*    程序员只需要编写mapper接口（相当于dao接口） 即可 。 mybatis会自动的为 mapper接口生产动态代理实现类
*    但是要遵循一些规范 ：
*                   1： mapper 接口的名字 要和mapper映射文件的namespace的值相同
*                   2： mapper接口的方法名称 ，和mapper映射文件的statement的id相同
*                   3： mapper接口的方法参数只能有一个 ， 且类型要和mapper映射文件中statement的parameterType的值保持一致
*                   4： mapper接口的返回值类型 要和 mapper映射文件中statement的resuletType值 或 resultMap中的type值保持一致 。
*
* */

public class test1 {
    SqlSession session;
    @Before
    public void before() throws IOException {
        System.out.println("before.....获取session");
//        a)读取配置文件；
        InputStream is = Resources.getResourceAsStream("SqlMapConfig2.xml");

        //b)通过SqlSessionFactoryBuilder创建SqlSessionFactory会话工厂。
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        session = sessionFactory.openSession();
    }

    @After
    public void after(){
        session.close();
    }

    @Test
    public void test1() throws IOException {

        UserMapper userMapper =  session.getMapper(UserMapper.class);//返回的是一个代理，可以直接转成mapper对象

        //获取数据
        System.out.println(userMapper.findUserById(1));


        //保存
        User user2 = new User("xxx","x",new Date(),"xx");
        userMapper.save(user2);
        session.commit();

    }




}
