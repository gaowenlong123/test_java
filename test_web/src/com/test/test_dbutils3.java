package com.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.gao.model.myAccount;
import com.gao.utils.database.C3P0Utils;

//测试 ResultSetHandler 的子类

public class test_dbutils3 {

	@Test
	public void test1() throws SQLException{
		/*MapHandler
		适合取1条记录。把当前记录的列名和列值放到一个Map中*/
		String sql = "select * from account where id = 1";
		
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		/*{
			money:1000.0
			name:aaa
			id:1
		}*/
		Map<String, Object>  map = qr.query(sql, new MapHandler());
		
		for(Entry<String, Object> entry : map.entrySet()){
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}


	@Test
	public void test2() throws SQLException{
		/*MapListHandler
		适合取多条记录。把每条记录封装到一个Map中，再把Map封装到List中*/
		String sql = "select * from account";
		
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
	
		List<Map<String, Object>> list = qr.query(sql, new MapListHandler());
		
		for(Map<String,Object> rowdata : list){
			
			for(Entry<String, Object> entry : rowdata.entrySet()){
				System.out.println(entry.getKey() + ":" + entry.getValue());
			}
			
			System.out.println("--------------------------");
		}
		
	}
	
	@Test
	public void test3() throws SQLException{
		//ScalarHandler适合取单行单列数据
		String sql = "select count(*) from account";
		//String sql = "select sum(money) from account";
		
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		/*Object o = qr.query(sql, new ScalarHandler());
		System.out.println(o.getClass() + "--" + o);*/
		
		Long count = (Long) qr.query(sql, new ScalarHandler());
		System.out.println(count);
	}


	@Test
	public void test4() throws SQLException{
		//BeanHandler:适合取单行多列数据
		String sql = "select * from account where id=1";
		
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

		myAccount account = qr.query(sql, new BeanHandler<myAccount>(myAccount.class));

		System.out.println(account);
	}
	
	@Test
	public void test5() throws SQLException{
		//BeanListHandler:适合取多行多列数据
		String sql = "select * from account";
		
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		
		List<myAccount> list = qr.query(sql, new BeanListHandler<myAccount>(myAccount.class));
		
		for(myAccount a : list){
			System.out.println(a);
		}
	}
	
}
