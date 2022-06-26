package com.mine.controller;

import com.mine.pojo.User;
import com.mine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    //登录及验证
    @RequestMapping("/user/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String pwd,
            Model model,HttpSession session){

        User user = userService.getUserByName(username);

        if(user!=null && user.getPassword().equals(pwd)){
            session.setAttribute("User",username);//保存用户名到前台
            return "redirect:/index.html";
        }else{
            //如果错误就传msg信息到前台
            model.addAttribute("msg","用户名或密码错误");
            return "login";
        }
    }

    //注销
    @RequestMapping("/user/logout")
    public String loginOut(HttpSession session){
        session.invalidate();
        return "redirect:/index.html";
    }

    //注册
    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user",new User());//这里为了第58行传入的前端能正常显示
        return "register";
    }
    @PostMapping("/user/register")
    public String register(User user,Model model){
        User user1 = userService.getUserByName(user.getUsername());
        if(user1!=null) {  //用户名已存在，重新返回注册页面
            model.addAttribute("msg","用户名已存在");
            model.addAttribute("user",user);//将刚刚提交的信息返回到前端
            return "register";
        }
        userService.addUser(user);
        return "redirect:/index.html";
    }

}
