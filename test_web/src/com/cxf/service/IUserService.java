package com.cxf.service;

import com.cxf.others.exception.UserException;
import com.cxf.model.User;

public interface IUserService {
	/**
	 * 注册业务
	 * @param user
	 */
	public void register(User user);




	/**
	 * 登录业务1
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String username, String password);



	/**
	 * 登录业务2
	 * @param user
	 * @return
	 */
	public User  login(User user)throws UserException;

	/**
	 * 判断用户是否存在
	 * @param username
	 * @return
	 */


	public boolean userExist(String username);
}
