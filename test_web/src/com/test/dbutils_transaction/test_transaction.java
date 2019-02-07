package com.test.dbutils_transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.gao.utils.database.DBCPUtils;

/*
* 三种现象 ：      1：脏读 ： 一个事务读取了另一个未提交的事务
* 				   2：不可重复读 ： 读到另外一个线程update提交的数据 ，不可重复读就发生了
* 				   3：虚读（幻读）：读到另外一个线程insert自动提交的数据 ，造成数据数量的更改
*
* 事务的隔离级别：   1：读到未提交的  ： 以上三种情况都可以发生                           TRANSACTION_READ_UNCOMMITTED
* 					2：读到已提交    ： 避免脏读  。 其他都会发生 （oracle默认）          TRANSACTION_READ_COMMITTED
* 				    3：可重复读     ：避免脏读，不可重复读。虚读有可能发生（mysql默认）   TRANSACTION_REPEATABLE_READ
* 				    例如 ： 在这个级别中，当update提交前后，该等级下的线程是阻塞的 ，读取的都是未更改的数据
*
* 					4：避免脏读，不可重复读，虚读。                                       TRANSACTION_SERIALIZABLE
*
* */

//注意想要 构成事务回滚 需要将数据库的引擎换成 InnoDB
public class test_transaction {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		try {

			 conn = DBCPUtils.getConnection();
			
			 //设置隔离级别
			 conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
			
			 //开启事务
			 conn.setAutoCommit(false);
			 

			 stmt = conn.createStatement();
			

			int a =stmt.executeUpdate("update account set money=money-100 where name='wang'");

			System.out.println(a);

			int i = 10 / 0;

			int b =stmt.executeUpdate("update account set money=money+100 where name='li'");
			System.out.println(b);

			//提交事务
			conn.commit();

		} catch (Exception e) {
//			e.printStackTrace();

			try {
				//回滚事务
				conn.rollback();
                System.out.println("回滚事务");

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			DBCPUtils.close(null, stmt, conn);
		}
		
	}

}
