package com.lbh.controller;

import com.lbh.entity.User;
import com.lbh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Advancer on 2018/1/17 15:47.
 * auth: lbh
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/addUser")
    public void addUser(){
        userService.addUser();
    }

    @RequestMapping("/findUser")
    public List<User> findUser(){
        List<User> userList = userService.findAllUser();
        for (User user : userList) {
            System.out.println(user);
        }
        return userList;
    }

}
