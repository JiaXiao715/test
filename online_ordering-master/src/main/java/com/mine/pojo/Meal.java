package com.mine.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Meal {
    private int meal_id; //菜的编号
    private int series_id; //菜品id
    private String meal_name; //菜名
    private String meal_description; //菜的描述
    private BigDecimal meal_price; //菜的单价
    private String meal_image; //菜的图片地址

    private Meal_series meal_series; //菜品类
}
