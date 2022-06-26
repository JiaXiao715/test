package com.mine.controller;

import com.mine.pojo.Cart;
import com.mine.pojo.Meal;
import com.mine.pojo.User;
import com.mine.service.CartService;
import com.mine.service.MealService;
import com.mine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    MealService mealService;
    @Autowired
    UserService userService;
    @Autowired
    CartService cartService;

    //购物车: 展示用户已加入的购物车的菜
    @PostMapping("/cart")
    public String cart(@RequestParam("username")String username,
                       @RequestParam("meal_id")int meal_id,
                       @RequestParam("price") BigDecimal price,
                       @RequestParam("number")int number,
                       Model model){
        User user = userService.getUserByName(username);
        if(user==null){ //如果找不到用户，转到登录页
            model.addAttribute("msg","请先登录");
            return "login";
        }
        boolean flag=false; //菜品是否重复
        List<Meal> meals = mealService.queryAllMeal();
        List<Cart> carts = cartService.queryAllCartByUserId(user.getUser_id());
        for (Cart cart : carts) { //检查当前的菜品是否重复
            if(cart.getMeal_id()==meal_id) flag=true;
        }
        if(flag){//如果重复，则更新其数量,价格
            cartService.updateCart(new Cart(user.getUser_id(),meal_id,price,number));

        }else{//如果不重复
            //将刚提交的菜品也加入到购物车数据库中
            cartService.addCart(new Cart(user.getUser_id(),meal_id,price,number));
        }
        //通过用户id找到该用户的所有加入购物车的菜
        List<Cart> cartList = cartService.queryAllCartByUserId(user.getUser_id());
        model.addAttribute("cartList",cartList);
        model.addAttribute("meals",meals);
        //计算购物车总金额
        BigDecimal sum=new BigDecimal("0");
        for (Cart cart : cartList) {
            sum=sum.add(cart.getPrice());
        }
        model.addAttribute("sum",sum);
        return "meal/cart";
    }

    //展示用户的购物车
    @GetMapping("/cartList")
    public String cart(@RequestParam("username")String username,
                       Model model){
        User user = userService.getUserByName(username);
        if(user==null){ //如果找不到用户，转到登录页
            model.addAttribute("msg","请先登录");
            return "login";
        }
        List<Meal> meals = mealService.queryAllMeal();
        //通过用户id找到该用户的所有加入购物车的菜
        List<Cart> cartList = cartService.queryAllCartByUserId(user.getUser_id());
        model.addAttribute("cartList",cartList);
        model.addAttribute("meals",meals);
        //计算购物车总金额
        BigDecimal sum=new BigDecimal("0");
        for (Cart cart : cartList) {
            sum=sum.add(cart.getPrice());
        }
        model.addAttribute("sum",sum);
        return "meal/cart";
    }

    //删除购物车某菜的数据
    @RequestMapping("/cart/delete")
    public String cartDelete(@RequestParam("cart_id")int cart_id,
                             @RequestParam("username")String username,
                             Model model){
        List<Meal> meals = mealService.queryAllMeal();
        User user = userService.getUserByName(username);
        //从购物车中删除某菜色
        cartService.deleteCart(cart_id);
        //通过用户id找到该用户的所有加入购物车的菜
        List<Cart> cartList = cartService.queryAllCartByUserId(user.getUser_id());
        model.addAttribute("cartList",cartList);
        model.addAttribute("meals",meals);
        //计算购物车总金额
        BigDecimal sum=new BigDecimal("0");
        for (Cart cart : cartList) {
            sum=sum.add(cart.getPrice());
        }
        model.addAttribute("sum",sum);
        return "meal/cart";
    }
}
