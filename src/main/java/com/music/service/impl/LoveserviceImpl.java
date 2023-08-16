package com.music.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.music.mapper.LoveMapper;
import com.music.pojo.LoveCheckVO;
import com.music.pojo.LoveMusicVO;
import com.music.pojo.Music;
import com.music.pojo.PageBean;
import com.music.service.LoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoveServiceImpl implements LoveService {
    @Autowired
    private LoveMapper loveMapper;
    /*
    用户收藏列表
    * */
    @Override
    public PageBean getById(Integer page, Integer pageSize,Long userId) {
        //设置分页参数
        PageHelper.startPage(page,pageSize);
        //执行查询
        List<LoveMusicVO> songList = loveMapper.getById(userId);
        Page<LoveMusicVO> p=(Page<LoveMusicVO>) songList;
        //封装结果
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    /*
    * 检测喜欢列表*/
    @Override
    public LoveCheckVO check(Long userId, Integer musicId) {
        return loveMapper.check(userId,musicId);
    }

    /*
    * 添加收藏*/
    @Override
    public void addLove(Long userId, Integer musicId) {
        loveMapper.insert(userId,musicId);
    }

    /*
    * 移除收藏列表*/
    @Override
    public void remove(Long userId, Integer musicId) {
        loveMapper.delete(userId,musicId);
    }
}
