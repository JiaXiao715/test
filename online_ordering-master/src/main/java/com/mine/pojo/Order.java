package com.mine.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;


@Data
public class Order {
    private int order_id;   //订单id
    private int user_id;    //用户id
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private String order_time;  //下单时间
    private String order_address; //收货人地址
    private String order_phone; //收货人电话
    private BigDecimal order_price; //付款总价
    private String order_state; //订单备注
    private String order_name; //收货人姓名

    //除了order_id的构造函数，因为order_id在数据库种自增
    public Order(int user_id, String order_time, String order_address, String order_phone, BigDecimal order_price, String order_state, String order_name) {
        this.user_id = user_id;
        this.order_time = order_time;
        this.order_address = order_address;
        this.order_phone = order_phone;
        this.order_price = order_price;
        this.order_state = order_state;
        this.order_name = order_name;
    }
}
