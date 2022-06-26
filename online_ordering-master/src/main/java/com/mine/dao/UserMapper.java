package com.mine.dao;

import com.mine.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    boolean addUser(User user);

    User getUserByName(String name);

    boolean updateUser(User user);
}
