package com.music.service;

import com.music.pojo.LoveCheckVO;
import com.music.pojo.LoveMusicVO;
import com.music.pojo.PageBean;

import java.util.List;

public interface LoveService {
    /*
    * 获取用户收藏列表*/
    PageBean getById(Integer page, Integer pageSize,Long userId);

    LoveCheckVO check(Long userId, Integer musicId);

    /*
    * 添加收藏*/
    void addLove(Long userId, Integer musicId);

    /*
    * 移除收藏列表*/
    void remove(Long userId, Integer musicId);
}
