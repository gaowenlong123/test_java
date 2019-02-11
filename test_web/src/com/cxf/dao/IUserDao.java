package com.cxf.dao;

import com.cxf.model.User;

/*  先写接口 ，在写接口的实现类 ，这样到后期好维护 */
//IUserDao dao = new OracleUserDaoImpl();  这样做的好处是，如果我要重新换个数据库，难道我要重新写sql吗？
//正如上面可以实现类的多态 ， 创建一个父类接口对象，实现那个子类的都可以

public interface IUserDao {

	/**
	 * 插入一条数据到数据库
	 * @param user
	 */
	public void insert(User user);




	/**
	 * 通过用户名和密码查找用户
	 * @param username
	 * @param password
	 * @return
	 */
	public User findUser(String username, String password);

	/**
	 * 通过用户名查询用户
	 * @param username
	 * @return
	 */
	public User findUser(String username);
}
