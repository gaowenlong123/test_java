package com.cxf.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class ManagerThreadLocal {

	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	public static Connection getConnection(){
		try {
			Connection conn = tl.get();
			//第一次是空
			if(conn == null){
				//从数据源取
				conn = C3P0Utils.getConnection();
				tl.set(conn);
				System.out.println("第一次从数据源获取connection对象:" + conn);
			}else{

				System.out.println("第n次从ThreadLocal获取connection对象");
			}
			
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 开启事务
	 */
	public static void  beginTransaction(){
		try {
			//开始事务的同时 ，也就实例化数据库连接对象 。 十分巧妙
			getConnection().setAutoCommit(false);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	/**
	 * 回滚事务
	 */
	public static void rollbackTransaction(){
		try {
			getConnection().rollback();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	

	/**
	 * 提交事务
	 */
	public static void commitTransaction(){
		try {
			getConnection().commit();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭连接
	 */
	public static void close(){
		try {
			getConnection().close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
