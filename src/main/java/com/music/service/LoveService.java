package com.music.service;

import com.music.pojo.LoveMusicVO;

import java.util.List;

public interface LoveService {
    /*
    * 获取用户收藏列表*/
    List<LoveMusicVO> getById(Long userId);

}
