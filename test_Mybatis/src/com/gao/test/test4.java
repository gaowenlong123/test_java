package com.gao.test;

import com.gao.mapper.OrderMapper;
import com.gao.mapper.UserMapper;
import com.gao.model.OrderDetail;
import com.gao.model.Orders;
import com.gao.model.OrdersExt;
import com.gao.model.User;
import com.gao.vo.UserQueryVO;
import org.apache.ibatis.cache.impl.PerpetualCache;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


//缓存

public class test4 {
    SqlSession session;


    /**
     * 一级缓存
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {

        InputStream is = Resources.getResourceAsStream("SqlMapConfig3.xml");

        //1.SqlSessionFactory会话工厂。
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        //2.会话
        SqlSession  session = sessionFactory.openSession();

        //3.通过会话获取dao接口
        UserMapper mapper = session.getMapper(UserMapper.class);

        /**
         * 默认情况下，一级缓存，就是session级别缓存是开启
         * 保存，删除，更新，一级缓存的数据会自动清空，下次查询，会执行sql语句
         */
        User user1 =  mapper.findUserById(1);
        System.out.println("user1:" + user1);

        // 何修改，添加，删除的操作都会清除数据
        mapper.save(new User("广东雨神","1",null,"广东"));

        User user2 =  mapper.findUserById(1);
        System.out.println("user2:" + user2);

        session.commit();
        session.close();

    }


    /**
     * 二级缓存
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {

        InputStream is = Resources.getResourceAsStream("SqlMapConfig3.xml");

        //1.SqlSessionFactory会话工厂。
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        //2.会话
        SqlSession  session1 = sessionFactory.openSession();
        SqlSession  session2 = sessionFactory.openSession();
        SqlSession  session3 = sessionFactory.openSession();

        //3.获取dao
        UserMapper mapper1 = session1.getMapper(UserMapper.class);
        UserMapper mapper2 = session2.getMapper(UserMapper.class);
        UserMapper mapper3 = session3.getMapper(UserMapper.class);

        //4.通过第一个session 缓存数据
        User user1 =  mapper1.findUserById(1);
        System.out.println("user1" + user1);
        //注意：session关闭后，才会提交到二级缓存
        session1.close();

        //保存用户，二级缓存也会清空  ，也可以自定义是否清除二级缓存
        mapper3.save(new User("斗门雨神","1",null,"广东"));
        session3.commit();
        session3.close();


       //6.通过第二个session获取数据
        User user2 =  mapper2.findUserById(1);
        System.out.println("user2" + user2);
        session2.close();


    }
}
