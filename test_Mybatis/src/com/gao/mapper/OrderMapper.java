package com.gao.mapper;

import com.gao.model.Orders;
import com.gao.model.OrdersExt;

import java.util.List;

public interface OrderMapper {

    public OrdersExt findOrderById(int id);

    public Orders findOrderById2(int id);


    public Orders findOrderById3(int id);

    /**
     * 懒加载定单的用户数据
     * @return
     */
    public List<Orders> findOrderAndUserByLazyloading();
}
