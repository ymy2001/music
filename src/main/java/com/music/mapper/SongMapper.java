package com.music.mapper;

import com.music.pojo.Music;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SongMapper {
    /*
    * 分页查寻全部歌曲*/
    //@Select("select * from song limit #{start},#{pageSize};")
    //List<Music> getSong(Integer start,Integer pageSize);
    /*
    * 获取总记录数*/
    //@Select("select count(*) from song")
   //public Long count();
    /*
    * 设置为动态查询*/
    //@Select("select * from song")
    List<Music> getSong(String search);
}
