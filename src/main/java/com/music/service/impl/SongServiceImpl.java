package com.music.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.music.context.BaseContext;
import com.music.mapper.SongMapper;
import com.music.mapper.UserMapper;
import com.music.pojo.HomePageVO;
import com.music.pojo.Music;
import com.music.pojo.PageBean;
import com.music.pojo.User;
import com.music.service.SongService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SongServiceImpl implements SongService {
    @Autowired
    private SongMapper songMapper;
    @Autowired
    private UserMapper userMapper;
    /*
    * 实现分页查询*/
    @Override
    public PageBean getSong(Integer page, Integer pageSize,String search,Integer type) {
        //设置分页参数
        PageHelper.startPage(page,pageSize);
        //执行查询
        List<Music> songList = songMapper.getSong(search,type);
        Page<Music> p=(Page<Music>) songList;
        //封装结果
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    /*
    * 获取全部的歌曲，也许也有条件*/
    @Override
    public HomePageVO getAll(String search) {
        String name = BaseContext.getCurrentName();
        log.info("当前用户：{}",name);
        User user = userMapper.getByname(name);
        HomePageVO hp=new HomePageVO();
        List<Music> all = songMapper.getAll(search);
        BeanUtils.copyProperties(user,hp);
        //BeanUtils.copyProperties(all,hp);
        hp.setRows(all);
        return hp;
    }
}
