package com.springboot.junit.service;

import com.springboot.junit.pojo.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName springboot_junit_demo
 * @Description TODO
 * @Author liuchj
 * @Date 2019/08/22 10:27
 * @Version 1.0
 **/
@Service
public class UserService {


    public User getOne(){
        return  new User(12,"tom",18,1);
    }

    public List<User> getAll(){
        List<User> userlist=new ArrayList<>();
        User user1=new User(12,"tom",18,1);
        User user2=new User(11,"Lily",18,0);
        User user3=new User(10,"Lucy",18,0);
        userlist.add(user1);
        userlist.add(user2);
        userlist.add(user3);
        return userlist;
    }
}
