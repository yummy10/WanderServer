package org.example.controller;

import org.example.entity.MyString;
import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public MyString create(@RequestBody User user) {
        if(userService.countUserName(user)==0){
            userService.create(user);
            return new MyString("用户插入成功。");
        }else {
            return new MyString("错误: 用户名已存在。");
        }
    }

    @PostMapping("/change")
    public User change(@RequestBody ChangePasswordRequest user) {
        return userService.change(user.getUser(),user.getNewPassword());
    }
    private static class ChangePasswordRequest {
        private User user;
        private String newPassword;

        // 添加一个无参构造函数
        public ChangePasswordRequest() {}

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public String getNewPassword() {
            return newPassword;
        }

        public void setNewPassword(String newPassword) {
            this.newPassword = newPassword;
        }
    }

}
