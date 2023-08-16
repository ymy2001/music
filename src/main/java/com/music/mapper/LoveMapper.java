package com.music.mapper;

import com.music.pojo.LoveCheckVO;
import com.music.pojo.LoveMusicVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LoveMapper {
    /*
    * 根据用户id获取当前的收藏列表*/
    List<LoveMusicVO> getById(Long userId);

    /*
    * 判断用户收藏状态*/
    @Select("select * from lovemusic where user_id=#{userId} and music_id=#{musicId}")
    LoveCheckVO check(Long userId, Integer musicId);

    /*
    * 添加收藏*/
    @Insert("insert into lovemusic(user_id, music_id) VALUES (#{userId},#{musicId})")
    void insert(Long userId, Integer musicId);
    /*
    * 移除收藏歌曲*/
    @Delete("delete from lovemusic where user_id=#{userId} and music_id=#{musicId}")
    void delete(Long userId, Integer musicId);
}
