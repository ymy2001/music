package com.music.mapper;

import com.music.pojo.LoveMusicVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LoveMapper {
    /*
    * 根据用户id获取当前的收藏列表*/
    List<LoveMusicVO> getById(Long userId);
}
