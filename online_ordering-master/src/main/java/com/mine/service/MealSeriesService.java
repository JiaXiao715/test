package com.mine.service;

import com.mine.dao.MealSeriesMapper;
import com.mine.pojo.Meal;
import com.mine.pojo.Meal_series;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MealSeriesService {

    @Autowired
    MealSeriesMapper mealSeriesMapper;

    public List<Meal> queryAllSeries(){
        return mealSeriesMapper.queryAllSeries();
    }

    public Meal_series getSeriesById(int id){
        return mealSeriesMapper.getSeriesById(id);
    }
}
