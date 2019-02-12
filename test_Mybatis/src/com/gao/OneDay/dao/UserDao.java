package com.gao.OneDay.dao;

import com.gao.model.User;

public interface UserDao {

    /**
     * 保存一个用户
     * @param user
     */
    public void save(User user);


    public User findUserById(int id);

}
