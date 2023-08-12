package com.music.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.music.mapper.SongMapper;
import com.music.pojo.Music;
import com.music.pojo.PageBean;
import com.music.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    @Autowired
    private SongMapper songMapper;
    /*
    * 实现分页查询*/
    @Override
    public PageBean getSong(Integer page, Integer pageSize,String search) {
        //获取总记录数
        //Long count= songMapper.count();
        //获取分页结果列表
        //封装结果

        //设置分页参数
        PageHelper.startPage(page,pageSize);
        //执行查询
        List<Music> songList = songMapper.getSong(search);
        Page<Music> p=(Page<Music>) songList;
        //封装结果
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }
}
