package com.cxf.service.impl;

import com.cxf.dao.IUserDao;
import com.cxf.dao.impl.UserDaoImpl;
import com.cxf.others.exception.UserException;
import com.cxf.model.User;
import com.cxf.service.IUserService;

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
