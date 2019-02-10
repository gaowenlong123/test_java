package com.gao.service;

import com.gao.model.User;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2019/2/9 0009.
 */


@Component("userService123")  //beanID
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
