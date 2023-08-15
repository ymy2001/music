package com.music.service;

import com.music.pojo.LoveMusicVO;
import com.music.pojo.PageBean;

import java.util.List;

public interface LoveService {
    /*
    * 获取用户收藏列表*/
    PageBean getById(Integer page, Integer pageSize,Long userId);

}
