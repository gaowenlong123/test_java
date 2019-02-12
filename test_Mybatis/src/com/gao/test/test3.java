package com.gao.test;

import com.gao.mapper.OrderMapper;
import com.gao.mapper.UserMapper;
import com.gao.model.OrderDetail;
import com.gao.model.Orders;
import com.gao.model.OrdersExt;
import com.gao.model.User;
import com.gao.vo.UserQueryVO;
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

public class test3 {
    SqlSession session;
    @Before
    public void before() throws IOException {
        System.out.println("before.....获取session");
//        a)读取配置文件；
        InputStream is = Resources.getResourceAsStream("SqlMapConfig3.xml");

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

        UserMapper userMapper =  session.getMapper(UserMapper.class);


        //通过模型的包装类来查询
        UserQueryVO query = new UserQueryVO();

        User user = new User();
        user.setSex("2");//男性
        query.setUser(user);

        int  count = userMapper.findUserCount(query);
        System.out.println("男性的用户人数:" + count);

    }

    /**
     * 结果类型resultMap   先设置别名与实际字段的映射关系
     * /* 这里使用别名是为了模拟 数据库与 程序运行环境中字段值不一致的情况 ，
     * 可以在上头设置映射，那么程序就可以识别了
     *
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {

        UserMapper userMapper =  session.getMapper(UserMapper.class);

        User  user = userMapper.findUserByIdResultMap(1);
        System.out.println("用户数据:" + user);

    }


    /**
     * 动态SQL 可以写if和where
     * @throws IOException
     */
    @Test
    public void test3() throws IOException {

        UserMapper userMapper =  session.getMapper(UserMapper.class);

        //查询条件
        UserQueryVO query = new UserQueryVO();

        User user = new User();
        user.setSex("1");//男性
        user.setUsername("张");
        query.setUser(user);

        List<User> users = userMapper.findUserList(query);
        System.out.println(users);
    }


    /**
     * if和where讲解  查询多个ID 用对象的属性是数组来做
     * @throws IOException
     */
    @Test
    public void test4() throws IOException {

        UserMapper userMapper =  session.getMapper(UserMapper.class);

        //查询条件
        UserQueryVO query = new UserQueryVO();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(10);
        ids.add(16);
        query.setIds(ids);
        System.out.println(ids);
        List<User> users = userMapper.findUserByIds(query);
        System.out.println(users);
    }


    @Test
    public void test5() throws IOException {

        UserMapper userMapper =  session.getMapper(UserMapper.class);

        //查询条件
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(10);
        ids.add(16);

        List<User> users = userMapper.findUserByIds2(ids);
        System.out.println(users);
    }


    /**
     * 一对一 : 写个定单的扩展类
     * @throws IOException
     */
    @Test
    public void test6() throws IOException {

        OrderMapper  mapper =  session.getMapper(OrderMapper.class);

        OrdersExt ordersExt = mapper.findOrderById(3);

        System.out.println(ordersExt);
    }


    /**
     * 一对一 : 模型里有模型
     * @throws IOException
     */
    @Test
    public void test7() throws IOException {

        OrderMapper  mapper =  session.getMapper(OrderMapper.class);

        Orders order = mapper.findOrderById2(3);
        System.out.println(order);
        System.out.println(order.getUser());
    }

    /**
     * 一对多 : 模型里有集合
     * @throws IOException
     */
    @Test
    public void test8() throws IOException {

        OrderMapper  mapper =  session.getMapper(OrderMapper.class);
        Orders order = mapper.findOrderById3(3);
        System.out.println(order);
        System.out.println(order.getUser());
        System.out.println(order.getOrderDetails());
    }

    /**
     * 多对多   “王五下了  两个订单 每个订单都有两个商品” 但是用户是有多个
     * @throws IOException
     */
    @Test
    public void test9() throws IOException {

        UserMapper  mapper =  session.getMapper(UserMapper.class);

        List<User> users = mapper.findUserAndOrderInfo();
        for (User user : users){
            System.out.println("用户信息:" + user);
            for (Orders order : user.getOrderList()){
                System.out.println("定单信息:" + order);
                System.out.println("订单详情:");
                for (OrderDetail od :  order.getOrderDetails()){
                    System.out.println(od + ":" + od.getItems());
                }

                System.out.println("------------------------------");
            }

        }
    }


    /**
     * 懒加载
     * @throws IOException
     */
    @Test
    public void test10() throws IOException {

        OrderMapper  mapper =  session.getMapper(OrderMapper.class);

        List<Orders> list = mapper.findOrderAndUserByLazyloading();
        for (Orders order : list){
            System.out.println("订单信息:");
            System.out.println(order);

            System.out.println("订单所属的客户:");
            System.out.println(order.getUser());
        }

    }
}
