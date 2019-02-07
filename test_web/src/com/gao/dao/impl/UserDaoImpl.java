package com.gao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gao.dao.IUserDao;
import com.gao.model.User;
//import com.gao.utils.database.C3P0Utils;
import com.gao.utils.database.JNDIUtils;


/* 用户接口的实现类 */

public class UserDaoImpl implements IUserDao {

	@Override
	public void insert(User user) {

		Connection conn = null;
		PreparedStatement ps = null;

		// 写JDBC代码
		try {

			// 1.注册驱动
			// 2.获取connection对象
			conn = JNDIUtils.getConnection();

			// 3.获取Statement对象
			String sql = "insert into t_user (username,password,email,birthday) values(?,?,?,?)";
			ps = conn.prepareStatement(sql);

			// 设置参数
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			// 把传入的日期转换成时间戳 ，再根据时间戳转换为 sql.data
			if(user.getBirthday()==null){
				ps.setDate(4, null);
			}else {
				ps.setDate(4, new java.sql.Date(user.getBirthday().getTime()));
			}


			// 4.执行sql语句 delete/update/insert
			int r = ps.executeUpdate();
			System.out.println("受影响的结果行数:" + r);

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			// 5.关闭资源
			JNDIUtils.close(null, ps, conn);

		}
	}

	@Override
	public User findUser(String username, String password) {
		User user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		// 写JDBC代码
		try {
			// 1.注册驱动
			// 2.获取connection对象
			conn = JNDIUtils.getConnection();

			// 3.查询
			String sql = "select * from t_user where username = ? and password = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			rs = ps.executeQuery();


			//4.遍历
			while(rs.next()){

				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setBirthday(rs.getDate("birthday"));
				System.out.println(user);
			}


			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			// 5.关闭资源
			JNDIUtils.close(rs, ps, conn);
		}
		
		return user;
	}

	@Override
	public User findUser(String username) {
		User user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		// 写JDBC代码
		try {
			// 1.注册驱动
			// 2.获取connection对象
			conn = JNDIUtils.getConnection();

			// 3.查询
			String sql = "select * from t_user where username = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();

			//4.遍历
			while(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setBirthday(rs.getDate("birthday"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 5.关闭资源
			JNDIUtils.close(rs, ps, conn);
		}

		return user;
	}


	/*public static void main(String[] args) {
		// 1.创建dao对象
		IUserDao userDao = new UserDaoImpl();

		// 2.插入数据
		account user = new account();
		user.setPassword("123");
		user.setEmail("vip@qq.com");
		user.setBirthday(new Date());
		user.setUsername("test1");
		userDao.insert(user);
		
		//3.查询用户
		account user = userDao.findUser("test1", "1234");
		System.out.println(user);
	}*/
	
	/**
	 * 为什么写Dao时候，要写个接口，再写实现
	 * 1.目标是为了以后项目的维护方便
	 * 数据库有mysql/oracle
	 * 
	 */
	
/*	public static void main(String[] args) {
		//IUserDao dao = new OracleUserDaoImpl();
		OracleUserDaoImpl dao = new OracleUserDaoImpl();
		dao.insert(null);
		dao.findUser(null, null);
	}*/
}
