package com.springboot.junit.controller;

import com.springboot.junit.pojo.User;
import com.springboot.junit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/getUser/{id}")
    public User getUser(@PathVariable(value = "id") Integer id){
        User user = userService.getOne(id);
        return user;
    }

    @RequestMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAll();

    }


    public String returnVal(String param1, String param2) {
        return param1 + param2;
    }





}
