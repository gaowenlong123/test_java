package com.gao.service.impl;

import com.gao.model.User;
import com.gao.service.IUserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/2/9 0009.
 */


//@Component("userService123")  //beanID
@Service("userServiceA")     //上下的效果是一样的，只是装进bean里的时候不一样
public class UserServiceImpl implements IUserService {

    //平常给name赋值需要get set 。现在只需要在xml进行配置
    private String name;

    @Override
    public void add() {
        System.out.println("输出用户姓名：" + name);
    }

    @Override
    public void add(User user) {
        System.out.println("添加用户姓名：" + user);
    }


    @Override
    public int addUser(int num) {
        System.out.println("新增用户" +num);
//        int a =100/0;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
