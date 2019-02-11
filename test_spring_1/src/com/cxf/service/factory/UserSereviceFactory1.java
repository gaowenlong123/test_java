package com.cxf.service.factory;

import com.cxf.service.IUserService;
import com.cxf.service.impl.UserServiceImpl;

//工厂模式  返回某个接口的实现类
public class UserSereviceFactory1 {

    public static IUserService createUserService(){
        return new UserServiceImpl();
    }
}
