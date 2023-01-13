package com.dj.dao;

import com.dj.pojo.User;

public interface UserMapper {

    //通过username查询用户信息
    public User queryByUserName(String username);


}
