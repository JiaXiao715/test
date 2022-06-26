package com.mine.dao;

import com.mine.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {

    //增加订单
    boolean addOrder(Order order);

    //查找某用户id的所有订单
    List<Order> queryAllOrder(int user_id);

    //根据订单编号查询某订单
    Order getOrderByOrderId(int order_id);

    //根据下单时间查询某订单
    Order getOrderByOrderTime(String order_time);

}
