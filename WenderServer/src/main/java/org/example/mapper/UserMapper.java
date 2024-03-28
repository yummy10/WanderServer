package org.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.entity.User;

public interface UserMapper {
    User login(User user);
    Void create(User user);
    Integer countUserName(User user);
    int change(@Param("userName") String userName, @Param("userPassword") String userPassword, @Param("pw") String pw);
}
