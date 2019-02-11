package com.cxf.utils.database;


import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBCPUtils {

	/**
	 * 使用了连接池后，使用数据源来获取连接
	 * 数据源，也就是连接池
	 * 优化数据库连接的性能
	 *
	 * 问题： 使用tomcat 就用不了了
	 */
	private static DataSource ds = null;

	static{
		//属性对象
		Properties p = null;
		try {
			p = new Properties();
			//使用类加载器来读db配置文件
			p.load(DBCPUtils.class.getClassLoader().getResourceAsStream("db.properties"));
			System.out.println(p);
			//创建一个数据源
			ds = BasicDataSourceFactory.createDataSource(p);
			System.out.println("连接池"+ds);
		} catch (Exception e) {
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
