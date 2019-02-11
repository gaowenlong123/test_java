package com.test.dbutils_transaction;

import com.cxf.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 测试 ResultSetHandler 的子类
 * Created by Administrator on 2019/2/7 0007.
 */
public class test_dbutils2 {
    @Test
    public void test1() throws SQLException {
        //ArrayHandler:适合取1条记录。把该条记录的每列值封装到一个数组中Object[]

        String sql = "select * from account where id = ?";

        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
                                   //每列值封装到一个数组中
        Object[] objs = qr.query(sql, new ArrayHandler(), 1);
        for(Object o : objs){
            System.out.println(o.getClass() + "---" + o);
        }
    }

    @Test
    public void test2() throws SQLException {

/*		ArrayListHandler
		适合取多条记录。
		把每条记录的每列值封装到一个数组中Object[]，
		把数组封装到一个List中*/

        String sql = "select * from account";

        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        List<Object[]> list = qr.query(sql, new ArrayListHandler());

        //遍历
        for(Object[] objs : list){
            //每一行数据
            for(Object o : objs){
                System.out.println(o);
            }
            System.out.println("---------------");
        }
    }


    @Test
    public void test3() throws SQLException {
        // TODO Auto-generated method stub
		/*
		ColumnListHandler:取某一列的数据。封装到List中。*/

        String sql = "select * from account";

        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        //第一列 ， 也可以指定列
        List<Object> list = qr.query(sql, new ColumnListHandler(1));
//        List<Object> list = qr.query(sql, new ColumnListHandler("name"));

        for(Object o : list){
            System.out.println(o);
        }
    }


    @Test
    public void test4() throws SQLException{
/*		KeyedHandler
		取多条记录，
		每一条记录封装到一个Map中，
		再把这个Map封装到另外一个Map中，
		key为指定的字段值.默认第一个为KEY。*/

        String sql = "select * from account";

        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

        Map<Object, Map<String, Object>> data = qr.query(sql, new KeyedHandler("name"));

        //遍历数据
        for(Map.Entry<Object, Map<String, Object>> entry :data.entrySet()){
            //获取key
            System.out.println(entry.getKey());

            //获取value
            for(Map.Entry<String, Object> row : entry.getValue().entrySet()){
                System.out.println(row.getKey() + ":" + row.getValue());
            }

            System.out.println("---------------------");
        }
    }
}
