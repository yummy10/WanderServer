package org.example.service;

import org.example.entity.User;

public interface UserService {
    User login(User user);
    Void create(User user);
    Integer countUserName(User user);
    User change(User user, String pw);
    Void addIcon(String userName,String icon);
}
