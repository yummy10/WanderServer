package org.example.service;

import org.example.entity.User;
import org.example.mapper.PlaceMapper;
import org.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(User user){
        return userMapper.login(user);
    };
}