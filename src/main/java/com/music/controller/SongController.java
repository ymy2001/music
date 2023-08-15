package com.music.controller;

import com.music.context.BaseContext;
import com.music.pojo.*;
import com.music.service.SongService;
import com.music.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@Api(tags = "歌曲相关接口")
@RequestMapping("/song")
public class SongController {
    @Autowired
    private SongService songService;
    @Autowired
    private UserService userService;
    @ApiOperation("查找歌曲，分页")
    @GetMapping("/list")
    public Result getSong(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10")  Integer pageSize,
            String search,
            Integer type)
    {
        log.info("音乐模糊查询:{}",search);
        log.info("分页参数：{},{}",page,pageSize);
        log.info("音乐类型：{}",type);
        PageBean pageBean=songService.getSong(page,pageSize,search,type);
        return Result.success(pageBean);
    }

    @ApiOperation("查找歌曲")
    @GetMapping
    public Result allSong(String search){
        log.info("全部查询，条件:{}",search);
        HomePageVO musicList=songService.getAll(search);
        return Result.success(musicList);
    }
}
