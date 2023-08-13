package com.music.service.impl;

import com.music.mapper.LoveMapper;
import com.music.pojo.LoveMusicVO;
import com.music.service.LoveService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoveserviceImpl implements LoveService {
    @Autowired
    private LoveMapper loveMapper;
    /*
    用户收藏列表
    * */
    @Override
    public List<LoveMusicVO> getById(Long userId) {
        return loveMapper.getById(userId);
    }
}
