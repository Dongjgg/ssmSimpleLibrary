package com.dj.service;

import com.dj.dao.UserMapper;
import com.dj.pojo.User;

public class UserServiceImpl implements UserService {

    private UserMapper userMapper;
    public void setUserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    //通过用户名查询用户信息，service层调用dao层
    public User queryByUserName(String username) {
        return userMapper.queryByUserName(username);
    }
}
