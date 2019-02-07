package com.gao.utils.database;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


/* JNDI  只在 tomcat下 运行 */

public class JNDIUtils {

	/**
	 * 使用了连接池后，使用数据源来获取连接
	 * 数据源，也就是连接池
	 */
	private static DataSource ds;

	static{

		try {
			//读取数据源
			Context context = new InitialContext();
			//在
			ds = (DataSource) context.lookup("java:comp/env/jdbc/testmvc");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
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
