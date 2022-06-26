package com.mine.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Cart {
    private int cart_id; //购物车编号(一辆车选一种菜)
    private int user_id; //用户编号
    private int meal_id; //菜的编号
    private BigDecimal price; //单价
    private int count; //数量

    public Cart(int user_id, int meal_id, BigDecimal price, int count) {
        this.user_id = user_id;
        this.meal_id = meal_id;
        this.price = price;
        this.count = count;
    }
}
