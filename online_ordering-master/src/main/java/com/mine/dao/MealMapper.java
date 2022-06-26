package com.mine.dao;

import com.mine.pojo.Meal;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MealMapper {

    List<Meal> queryAllMeal();

    Meal getMealById(int id);

}
