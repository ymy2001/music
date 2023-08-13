package com.music.controller;

import com.music.context.BaseContext;
import com.music.pojo.LoveMusicVO;
import com.music.pojo.Result;
import com.music.service.LoveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@Api(tags = "喜欢列表接口")
@RequestMapping("/love")
public class LoveController {
    @Autowired
    private LoveService loveService;
    /*
    * 获取用户的收藏列表*/
    @ApiOperation("收藏列表")
    @GetMapping
    public Result loveMusic(){
        Long userId = BaseContext.getCurrentId();
        log.info("当前用户id：{}",userId);
        List<LoveMusicVO> loveList=loveService.getById(userId);
        return Result.success(loveList);
    }
}
