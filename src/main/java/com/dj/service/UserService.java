package com.dj.service;

import com.dj.pojo.User;

public interface UserService {

    //通过username查询用户信息
    public User queryByUserName(String username);
}
