package com.mine.dao;

import com.mine.pojo.Meal;
import com.mine.pojo.Meal_series;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MealSeriesMapper {

    List<Meal> queryAllSeries();

    Meal_series getSeriesById(int id);

}
