package com.test.dbutils_transaction;

import java.sql.Connection;

import org.junit.Test;

import com.cxf.service.IAccountService;
import com.cxf.service.impl.AccountServiceImpl;
import com.cxf.utils.ManagerThreadLocal;

public class test_transaction2 {


	//这个是直接调用 C3P0Utils
	@Test
	public void test1() {

		/**
		 * 转帐案例：无事务
		 * 从 aaa 帐号转 100 块钱给 bbb帐号
		 * 1.写Dao
		 * 2.写Service
		 * 3.测试业务
		 */
		
		IAccountService accountService = new AccountServiceImpl();
		accountService.transfer("aaa", "bbb", 100);
	}
	
	
	@Test
	public void test2() {

		/**
		 * 转帐案例：有事务
		 * 事务添加一般都写在service,是众多开发者一个规范
		 * 从 aaa 帐号转 100 块钱给 bbb帐号
		 * 1.在Dao写两个方法
		 *   findAccount(String name);
		 * 	 updateAccount(Account acount);
		 * 2.在service再写一个转账方法transfer1
		 * 
		 * 3.在transer1方法
		 *   1.查找 from的帐号
		 *   2.查找to帐号
		 *   3.更改两个账号的money数据
		 *   4.更新数据库
		 *   
		 * 4.加事务
		 *   更改dao写法
		 *   	1.dao给个构造方法，传递一个连接对象
		 *      2.执行sql语句的添加connection对象
		 *      3.在service获取一个连接，再传入dao构造方法中，接着就可以开启事务
		 *   
		 */
		IAccountService accountService = new AccountServiceImpl();
		accountService.transfer_Transaction("aaa", "bbb", 100);
		
		
	}

	//同一个线程 公用 一个数据库对象  。 因为在 ManagerThreadLocal 把线程池和数据库对象 进行了绑定
	@Test
	public void test3(){
		//当前线程【主线程】
		System.out.println(Thread.currentThread());
		Connection conn1 = ManagerThreadLocal.getConnection();
		Connection conn2 = ManagerThreadLocal.getConnection();
		System.out.println("conn1" + conn1);
		System.out.println("conn2" + conn2);
		
		//开一个线程
		new Thread(){
			public void run() {
				Connection conn3 = ManagerThreadLocal.getConnection();
				System.out.println("conn3" + conn3);
			};
		}.start();
		
	}
}
