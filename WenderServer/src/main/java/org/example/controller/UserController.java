package org.example.controller;

import org.example.entity.MyString;
import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

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
    @PostMapping("/addIcon")
    public MyString addIcon(@RequestPart("name") String name,
                            @RequestPart("image") MultipartFile file)throws IOException {
        name = name.substring(1, name.length() - 1);
        if (!file.isEmpty()) {
            String imageName = name.replace(" ", "_").toLowerCase();
            String imagePath = "users/images/" + imageName + ".jpg";
            String realImagePath = "images/user/" + imageName + ".jpg";
            File imageFile = new File("C:/Wander/WenderServer/WenderServer/src/main/resources/" + realImagePath);
            file.transferTo(imageFile.toPath());
            userService.addIcon(name,imagePath);
            return new MyString("用户插入成功。");
        } else {
            return new MyString("错误: 用户名已存在。");
        }
    }
    @GetMapping(value = "/images/{imagePath1}", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getImage(@PathVariable("imagePath1") String imagePath1) throws IOException {
        File file = new File("src/main/resources/images/user/" + imagePath1+".jpg");
        if (file.exists()) {
            return Files.readAllBytes(file.toPath());
        } else {
            throw new FileNotFoundException("Image not found: " + imagePath1);
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
