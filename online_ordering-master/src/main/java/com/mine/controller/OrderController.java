package com.mine.controller;

import com.mine.pojo.Cart;
import com.mine.pojo.Meal;
import com.mine.pojo.Order;
import com.mine.pojo.User;
import com.mine.service.CartService;
import com.mine.service.MealService;
import com.mine.service.OrderService;
import com.mine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class OrderController {

    @Autowired()
    OrderService orderService;
    @Autowired
    UserService userService;
    @Autowired
    CartService cartService;
    @Autowired
    MealService mealService;

    //从购物车转到订单页面
    @RequestMapping("/order")
    String order(
            @RequestParam("username")String username,
            Model model){
        User user = userService.getUserByName(username);
        List<Cart> carts = cartService.queryAllCartByUserId(user.getUser_id());
        List<Meal> meals = mealService.queryAllMeal();
        model.addAttribute("meals",meals);
        model.addAttribute("carts",carts);
        model.addAttribute("user",user);
        //计算购物车总金额
        BigDecimal sum=new BigDecimal("0");
        for (Cart cart : carts) {
            sum=sum.add(cart.getPrice());
        }
        model.addAttribute("sum",sum);
        //获取当前系统时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        model.addAttribute("date",df.format(new Date()));// new Date()为获取当前系统时间
        return "meal/order";
    }

    //订单提交成功，转到提示成功页面
    @PostMapping("/order/submit")
    String submitOrder(Order order, Model model){
        orderService.addOrder(order);
        //这里order的order_id是空，进入数据库会自动赋值,所以要获得order_id得从数据库把该订单找出来赋给order2
        Order order2 = orderService.getOrderByOrderTime(order.getOrder_time());
        model.addAttribute("order",order2);//把订单信息传给前端

        return "order/order_success";
    }

    //查看历史订单列表
    @RequestMapping("/order/history")
    String orderHistory(@RequestParam("username")String name,
                        Model model){
        User user = userService.getUserByName(name);
        if(user==null){ //如果找不到用户，转到登录页
            model.addAttribute("msg","请先登录");
            return "login";
        }
        List<Order> orders = orderService.queryAllOrder(user.getUser_id());
        model.addAttribute("orders",orders);
        return "order/order_list";
    }

    /*@GetMapping("/order/order_message")
    String orderMessage(@RequestParam("order_id")int order_id,
                        Model model){
        Order order = orderService.getOrderByOrderId(order_id);
        model.addAttribute(order_id);
        return "order/order_message";
    }*/
}
