package com.cxf.service;

import com.cxf.model.User;

/**
 * Created by Administrator on 2019/2/9 0009.
 */
public interface IUserService {

    public void add();

    public void add(User user);
    public int addUser(int num);
    public void updateUser();
    public void deleteUser();

}
