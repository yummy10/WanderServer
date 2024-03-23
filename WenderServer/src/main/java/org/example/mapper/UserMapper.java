package org.example.mapper;

import org.example.entity.User;

public interface UserMapper {
    User login(User user);
    Void create(User user);
    Integer countUserName(User user);
}
