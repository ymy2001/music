package com.music.controller;

import com.music.context.BaseContext;
import com.music.pojo.LoveCheckVO;
import com.music.pojo.LoveMusicVO;
import com.music.pojo.PageBean;
import com.music.pojo.Result;
import com.music.service.LoveService;
import com.music.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Result loveMusic(@RequestParam(defaultValue = "1") Integer page,
                            @RequestParam(defaultValue = "10")  Integer pageSize){
        Long userId = BaseContext.getCurrentId();
        log.info("当前用户id：{}",userId);
        PageBean loveList=loveService.getById(page,pageSize,userId);
        return Result.success(loveList);
    }
    /*
    * 添加收藏*/
    @ApiOperation("添加收藏")
    @GetMapping("/add")
    public Result addLove(Integer musicId){
        Long userId = BaseContext.getCurrentId();
        log.info("添加收藏用户id：{}，音乐id：{}",userId,musicId);
        //判断数据是否存在
        LoveCheckVO loveCheckVO=loveService.check(userId,musicId);
        if (loveCheckVO==null){
            loveService.addLove(userId,musicId);
            return Result.success(1);
        }
        return Result.error("收藏失败");
    }
    /*
    * 取消收藏*/
    @GetMapping ("/delete")
    @ApiOperation("取消收藏")
    public Result cancelLove(Integer musicId){
        Long userId = BaseContext.getCurrentId();
        log.info("添加收藏用户id：{}，音乐id：{}",userId,musicId);
        //判断数据是否存在
        LoveCheckVO loveCheckVO=loveService.check(userId,musicId);
        if (loveCheckVO!=null){
            loveService.remove(userId,musicId);
            return Result.success(0);
        }
        return Result.error("取消收藏失败");
    }
    /*
    * 查询收藏状态*/
    @ApiOperation("查询收藏状态")
    @GetMapping("/check")
    public Result check(Integer musicId){
        Long userId = BaseContext.getCurrentId();
        log.info("当前用户id：{}，当前歌曲：{}",userId,musicId);
        LoveCheckVO loveCheckVO=loveService.check(userId,musicId);
        if (loveCheckVO==null){
            return Result.success(0);
        }
        return Result.success(1);
    }

}
