package com.music.controller;

import com.music.pojo.Music;
import com.music.pojo.PageBean;
import com.music.pojo.Result;
import com.music.service.SongService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
    @ApiOperation("查找歌曲分页")
    @GetMapping("/list")
    public Result getSong(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10")  Integer pageSize,
            String search)
    {
        log.info("音乐数据查询:{}",search);
        log.info("分页参数：{},{}",page,pageSize);
        PageBean pageBean=songService.getSong(page,pageSize,search);
        return Result.success(pageBean);
    }

    @ApiOperation("查找歌曲")
    @GetMapping
    public Result allSong(String search){
        log.info("全部查询，条件:{}",search);
        List<Music> musicList=songService.getAll(search);
        return Result.success(musicList);
    }
}
