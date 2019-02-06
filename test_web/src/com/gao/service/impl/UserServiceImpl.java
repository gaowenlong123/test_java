package com.gao.service.impl;

import com.gao.dao.IUserDao;
import com.gao.dao.impl.UserDaoImpl;
import com.gao.exception.UserException;
import com.gao.model.User;
import com.gao.service.IUserService;

public class UserServiceImpl implements IUserService{

	//service中调用dao
	private IUserDao userDao = new UserDaoImpl();
	
	@Override
	public void register(User user) {

		userDao.insert(user);
	}

	@Override
	public User login(String username, String password) {

		return userDao.findUser(username, password);
	}

	@Override
	public User login(User user) throws UserException {
		User u = userDao.findUser(user.getUsername(), user.getPassword());
		if(u != null){
			return u;
		}else{
			throw new UserException("用户名和密码不正确");
		}

	}

	@Override
	public boolean userExist(String username) {
		User user = userDao.findUser(username);
		return user != null;
	}

}
