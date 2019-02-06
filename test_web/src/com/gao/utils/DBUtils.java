package com.gao.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;

public class DBUtils {

	private static String url = null;
	private static String user = null;
	private static String password = null;
	private static String driverClass = null;
	static{
		
		/*try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}*/

		try {
			//从db.properites取数据赋值给静态变量

			/**
			 * 以前使用Properties类来读.properties文件的内容
			 *
			 * 使用ResourceBundle 资源文件夹
			 *
			 */

			//GG
		/*	ResourceBundle rb = ResourceBundle.getBundle("db");//不需要写后缀名
			System.out.println(rb);
			url = rb.getString("url");
			user = rb.getString("user");
			password = rb.getString("password");
			driverClass = rb.getString("driverClass");*/



			//这种方式  properties文件必须放在src目录下
			InputStream in =DBUtils.class.getClassLoader().getResourceAsStream("db.properties");
			Properties p =new Properties();
			p.load(in);
			url = p.getProperty("url");
			user = p.getProperty("user");
			password = p.getProperty("password");
			driverClass = p.getProperty("dirverClass");



			System.out.println("从db.properites取数据:");
			System.out.println("url:" + url);
			System.out.println("user:" + user);
			System.out.println("password:" + password);
			System.out.println("driverClass:" + driverClass);

			Class.forName(driverClass);//加载驱动

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}

	}
	
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, user, password);
	}
	
	public static void close(ResultSet rs,Statement stmt,Connection conn){
		
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(stmt !=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn !=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
