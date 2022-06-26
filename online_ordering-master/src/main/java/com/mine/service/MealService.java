package com.mine.service;

import com.mine.dao.MealMapper;
import com.mine.pojo.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    @Autowired
    MealMapper mealMapper;

    public List<Meal> queryAllMeal(){
        return mealMapper.queryAllMeal();
    }

    public Meal getMealById(int id){
        return mealMapper.getMealById(id);
    }
}
