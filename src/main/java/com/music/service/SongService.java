package com.music.service;

import com.music.pojo.Music;
import com.music.pojo.PageBean;
import com.music.pojo.Result;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SongService {
    /*
    * 查找全部歌曲*/
    PageBean getSong(Integer page, Integer pageSize,String search,Integer type);

    /*
    * 查询全部的歌曲*/
    List<Music> getAll(String search);
}
