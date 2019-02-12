package com.gao.model;

import java.util.Date;

// 订单的扩展类 为了 实现多表查询 ，返回的数据 需要model来接收
public class OrdersExt extends Orders{

    private String username;
    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "OrdersExt{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}' + super.toString();
    }
}
