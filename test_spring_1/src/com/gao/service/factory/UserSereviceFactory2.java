package com.gao.service.factory;

import com.gao.service.IUserService;
import com.gao.service.impl.UserServiceImpl;

public class UserSereviceFactory2 {

    public IUserService createUserService(){
        return new UserServiceImpl();
    }
}
