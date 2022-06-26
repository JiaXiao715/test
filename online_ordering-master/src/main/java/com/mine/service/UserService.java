package com.mine.service;

import com.mine.dao.UserMapper;
import com.mine.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public boolean addUser(User user) {
        return userMapper.addUser(user);
    }

    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    public boolean updateUser(User user) {
        return userMapper.updateUser(user);
    }
}
