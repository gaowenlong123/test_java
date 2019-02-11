package com.gao.dao.impl;

import com.gao.dao.IUserDao;
import com.gao.model.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Repository("mydao2")
public class UserDaoImpl2 implements IUserDao {
    @Override
    public void add(User user) {
        System.out.println("dao2222 添加用户:" + user);
    }

    //自己定义一个初始化的方法
    @PostConstruct
    public void myInit(){
        System.out.println("自定义的初始化方法...");
    }

    @PreDestroy
    public void myDestroy(){
        System.out.println("自定义的销毁的方法...");
    }
}
