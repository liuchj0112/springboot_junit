package com.springboot.junit.controller;

import com.springboot.junit.pojo.User;
import com.springboot.junit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @projectName springboot_junit_demo
 * @Description TODO
 * @Author liuchj
 * @Date 2019/08/22 10:17
 * @Version 1.0
 **/

@RestController
public class UserController {



    @Autowired
    UserService userService;

    @RequestMapping("/getUser")
    public User getUser(){
        User user = userService.getOne();
        return user;
    }

    @RequestMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAll();

    }





}
