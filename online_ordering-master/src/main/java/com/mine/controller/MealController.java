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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MealController {

    @Autowired
    MealService mealService;

    //展示店铺里的所有菜色
    @GetMapping("/shop")
    public String shop(Model model){
        List<Meal> meals = mealService.queryAllMeal();
        model.addAttribute("meal_list",meals);
        return "meal/shop";
    }

    //展示具体某个菜的信息
    @GetMapping("/meal/{id}")
    public String meal(@PathVariable("id")Integer id, Model model){
        Meal meal = mealService.getMealById(id);
        model.addAttribute("meal",meal);
        return "meal/meal";
    }

}
