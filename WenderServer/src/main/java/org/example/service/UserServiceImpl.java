package org.example.service;

import org.example.entity.User;
import org.example.mapper.UserMapper;
import org.example.util.CryptoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(User user){
        user.setUserName(CryptoUtils.decrypt(user.getUserName()));
        user.setUserPassword(CryptoUtils.decrypt(user.getUserPassword()));
        user = userMapper.login(user);
        if(user==null){return null;}
        user.setUserName(CryptoUtils.encrypt(user.getUserName()));
        user.setUserPassword(CryptoUtils.encrypt(user.getUserPassword()));
        return user;
    }
    @Override
    public Void create(User user){
        return userMapper.create(user);
    }
    @Override
    public Integer countUserName(User user){
        user.setUserName(CryptoUtils.decrypt(user.getUserName()));
        user.setUserPassword(CryptoUtils.decrypt(user.getUserPassword()));
        return userMapper.countUserName(user);
    }

    @Override
    public User change(User user, String pw) {
        user.setUserName(CryptoUtils.decrypt(user.getUserName()));
        user.setUserPassword(CryptoUtils.decrypt(user.getUserPassword()));
        pw = CryptoUtils.decrypt(pw);
        int rowsUpdated = userMapper.change(user.getUserName(),user.getUserPassword(),pw);
        if (rowsUpdated == 0) {
            return null;
        }
        user.setVIP(false);
        user.setUserID(0);
        user.setUserName(CryptoUtils.encrypt(user.getUserPassword()));
        user.setUserPassword(CryptoUtils.encrypt(pw));
        return user;
    }
    @Override
    public Void addIcon(String userName,String icon){
        userMapper.addIcon(userName,icon);
        return null;
    }
}
