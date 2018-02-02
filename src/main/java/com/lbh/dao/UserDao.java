package com.lbh.dao;

import com.lbh.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Advancer on 2018/1/23 11:00.
 * auth: lbh
 */
@Mapper
public interface UserDao {

    /**
     * 新增
     * @param user
     * @return
     */
    public void addUser(User user);

    /**
     * 查询
     * @return
     */
    public List<User> findAllUser();

}
