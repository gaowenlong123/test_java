package com.gao.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.gao.utils.DBUtils;


//day13 10   事务 ，mmp 这边演示也失败了
public class test_transaction {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		try {

			 conn = DBUtils.getConnection();
			
			 //��������ĸ��뼶��
//			 conn.setTransactionIsolation(Connection.TRANSACTION_NONE);
			
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
			DBUtils.close(null, stmt, conn);
		}
		
	}

}
