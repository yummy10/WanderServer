package org.example.controller;

import org.example.entity.MyString;
import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return userService.login(user);
    }

    @PostMapping("/create")
    public String create(@RequestBody User user) {
        if(userService.countUserName(user)==0){
            return "用户插入成功。";
        }else {
            return "错误: 用户名已存在。";
        }
    }
//    @PostMapping("/create")
//    public MyString create(@RequestBody User user) {
//        if(userService.countUserName(user)==0){
//            userService.create(user);
//            return new MyString("用户插入成功。");
//        }else {
//            return new MyString("错误: 用户名已存在。");
//        }
//    }
}
