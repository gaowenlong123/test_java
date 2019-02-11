package com.cxf.service.impl;

import com.cxf.model.User;
import com.cxf.dao.IUserDao;
import com.cxf.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Override
    public int addUser(int num) {
        System.out.println("新增用户" +num);
        return num;
    }

    @Override
    public void updateUser() {
        System.out.println("更新用户");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除用户");
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
