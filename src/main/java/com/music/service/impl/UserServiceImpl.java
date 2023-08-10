package com.music.service.impl;
import com.music.mapper.UserMapper;
import com.music.pojo.User;
import com.music.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Component
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    /*
    * 用户登录验证*/
    @Override
    public User login(User user) {
        return userMapper.getByIdAndName(user);
    }

    /*
    * 注册验证，根据用户姓名*/
    @Override
    public User register(String name) {
        return userMapper.getByname(name);
    }

    /*
    * 插入用户数据*/
    @Override
    public void insert(User user) {
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.insert(user);
    }

    /*
    * 查找用户信息*/
    @Override
    public User meassage(String username) {
        return userMapper.getByname(username);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }
}
