package com.mine.controller;

import com.mine.pojo.User;
import com.mine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //展示个人主页信息
    @GetMapping("/user_center/{name}")
    public String userCenter(@PathVariable("name")String name, Model model){
        User user = userService.getUserByName(name);
        if(user==null){ //如果找不到用户，转到登录页
            model.addAttribute("msg","请先登录");
            return "login";
        }
        model.addAttribute("user",user);
        return "user/user_center";
    }
    @GetMapping("/user_center")
    public String userCenter(Model model){
            model.addAttribute("msg","请先登录");
            return "login";
    }

    //修改个人信息
    @GetMapping("/user/update/{name}")
    public String updateUser(@PathVariable("name")String name, Model model){
        User user = userService.getUserByName(name);
        model.addAttribute("user",user);
        return "user/user_update";
    }
    @PostMapping("/user/update")
    public String updateUser(User user,Model model){
        userService.updateUser(user);
        model.addAttribute("msg_update","修改个人信息成功");
        return "user/user_center";
    }
}
