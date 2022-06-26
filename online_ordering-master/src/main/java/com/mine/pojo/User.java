package com.mine.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int user_id; //用户编号
    private String username; //用户名
    private String password; //登陆密码
    private String truename; //真实姓名
    private String email;  //邮箱
    private String phone; //手机号
    private String address; //收货地址
}
