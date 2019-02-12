package com.gao.vo;

import com.gao.model.Order;
import com.gao.model.User;

//包装类  ： 对象 模型来说 有用户表 也用订单表 。当然肯定也有用户，订单关联的表
// SELECT u.* ，o.* FROM user u， orders o WHRER u.id =o.id AND o.number='1000010'

public class UserQueryVO {

    private User user;

    private Order order;
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
