package com.gao.mapper;

import com.gao.model.Orders;
import com.gao.model.OrdersExt;

import java.util.List;

public interface OrderMapper {

    public OrdersExt findOrderById(int id);

    //根据ID查 订单和用户信息   一对一
    public Orders findOrderById2(int id);

    //根据ID查 订单和用户信息，订单详情   一对多
    public Orders findOrderById3(int id);

    /**
     * 懒加载定单的用户数据
     * @return
     */
    public List<Orders> findOrderAndUserByLazyloading();
}
