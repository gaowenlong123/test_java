package com.gao.service;

import com.gao.dao.UserDaoImpl;
import com.gao.model.User;
import com.gao.dao.IUserDao;
import com.gao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service("myUserService")
public class UserActionServiceImpl implements IUserService {

//    private  IUserDao userDao = new UserDaoImpl();  不需要new出来 ，用spring直接注入 。xml就是自动调用get。set方法。所以必须提供该方法
//                                                        但是如果是注解，也不需要getset方法
    @Autowired //spring会自动注入userDao赋值
    @Qualifier("mydao2")
    private IUserDao userDao;

    @Override
    public void add(User user) {

        System.out.println("service 添加用户:" + user);
        //调用dao
        userDao.add(user);
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void add() {
        System.out.println("创建用户...." + name);
    }



    public UserActionServiceImpl() {
        System.out.println("UserServiceImpl（）调用了");
    }

//    用注解无需get set方法
//    public void setUserDao(IUserDao userDao) {
//        this.userDao = userDao;
//    }
}
