package com.lbh.service;

import com.lbh.dao.UserDao;
import com.lbh.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Advancer on 2018/1/23 14:23.
 * auth: lbh
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void addUser(){
        User user = new User("lbh", "24", 10000);
        userDao.addUser(user);
    }

    public List<User> findAllUser(){
        return userDao.findAllUser();
    }

}
