package com.gao.dao;

import com.gao.model.User;
import org.springframework.stereotype.Repository;

@Repository("mydao")
public class UserDaoImpl implements IUserDao{
    @Override
    public void add(User user) {
        System.out.println("dao 添加用户:" + user);
    }
}
