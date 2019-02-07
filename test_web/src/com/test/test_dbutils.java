package com.test;

import com.gao.model.myAccount;
import com.gao.utils.database.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * dbutils 是对数据库操作语句的封装 ，简化
 * Created by Administrator on 2019/2/7 0007.
 */


public class test_dbutils {

    @Test
    public void test1() throws SQLException {
        //使用dbutils.jar 的QueryRunner

        //1：创建 QueryRunner 对象
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        //2:执行查询
        //resultSetHandler 结果集的处理器  ，直接把结果封装成 list 集合
        List<myAccount> list =qr.query("Select * from account" , new BeanListHandler<myAccount>(myAccount.class));

        //输出
        for (myAccount a : list){
            System.out.println(a);
        }

        //这里不需要的关闭数据量连接 ，因为这是用的pool ，用完就放回数据池中
    }


    //自己定义返回的数据
    @Test
    public void test2() throws SQLException{

        //1.创建queryrunner对象
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        //2.查询
        String sql = "select * from account";


        //相当于自己处理结果 ，然后自己实现并返回
        List<myAccount> accounts = qr.query(sql, new ResultSetHandler<List<myAccount>>(){

            @Override
            public List<myAccount> handle(ResultSet rs) throws SQLException {

                List<myAccount> list = new ArrayList<myAccount>();
                while(rs.next()){
                    myAccount account = new myAccount();
                    account.setId(rs.getInt("id"));
                    account.setName(rs.getString("name"));
                    account.setMoney(rs.getDouble("money"));
                    list.add(account);
                }
                return list;
            }

        });

        for(myAccount a : accounts){
            System.out.println(a);
        }
    }


    //dbutils的添加删除更新案例
    //1.添加数据
    @Test
    public void test3() throws SQLException{
        //1.创建queryrunner对象
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        //2.执行添加的sql语句
        String sql = "insert into account (name,money) values(?,?)";
        int r = qr.update(sql, "eee",1000.09);
        System.out.println("影响的行数" + r);
    }

    @Test
    /**
     * 删除数据
     */
    public void test4() throws SQLException{
        //1.创建queryrunner对象
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        //2.执行添加的sql语句
        String sql = "delete from account where id=?";
        int r = qr.update(sql,3);
        System.out.println("影响的行数" + r);
    }

    @Test
    /**
     * 更新数据
     */
    public void test5() throws SQLException{
        //1.创建queryrunner对象
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        //2.执行添加的sql语句
        String sql = "update account set name = ?,money = ? where id = ?";
        int r = qr.update(sql,"test",1000000,4);
        System.out.println("影响的行数" + r);
    }
}
