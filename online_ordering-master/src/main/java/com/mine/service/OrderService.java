package com.mine.service;

import com.mine.dao.OrderMapper;
import com.mine.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderMapper orderMapper;

    //增加订单
    public boolean addOrder(Order order){
        return orderMapper.addOrder(order);
    }

    //查找某用户id的所有订单
    public List<Order> queryAllOrder(int user_id){
        return orderMapper.queryAllOrder(user_id);
    }

    //根据订单编号查询某订单
    public Order getOrderByOrderId(int order_id){
        return orderMapper.getOrderByOrderId(order_id);
    }

    //根据下单时间查询某订单
    public Order getOrderByOrderTime(String order_time){
        return orderMapper.getOrderByOrderTime(order_time);
    }

}
