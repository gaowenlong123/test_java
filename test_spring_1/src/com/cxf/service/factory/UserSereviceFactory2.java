package com.cxf.service.factory;

import com.cxf.service.IUserService;
import com.cxf.service.impl.UserServiceImpl;

public class UserSereviceFactory2 {

    public IUserService createUserService(){
        return new UserServiceImpl();
    }
}
