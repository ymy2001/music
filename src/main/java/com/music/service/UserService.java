package com.music.service;

import com.music.pojo.User;

public interface UserService {
    /*
    * 用户登录*/
    User login(User user);

    /*
    * 注册验证*/
    User register(String name);

    /*
    * 插入用户数据*/
    void insert(User user);

    /*
    * 查找用户数据*/
    User meassage(String username);

    /*
    * 根据用户id更新数据*/
    void update(User user);
}
