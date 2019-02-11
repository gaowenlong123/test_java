package com.cxf.dao.impl;

import com.cxf.dao.IUserDao;
import com.cxf.model.User;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class UserJdbcDaoImpl extends JdbcDaoSupport implements IUserDao {


    //这个方法 不用创建一个属性 JdbcTemplate ，因为继承的父类已经创建了
    @Override
    public void add(User user) {

        System.out.println("dao 添加用户:" + user);

        getJdbcTemplate().update("insert t_user (username,password) values (?,?)",user.getUsername(),user.getPassword());
    }
}
