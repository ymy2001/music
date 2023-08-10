package com.music.controller;

import com.music.context.BaseContext;
import com.music.pojo.Result;
import com.music.pojo.User;
import com.music.service.UserService;
import com.music.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

@Slf4j
@RestController
public class UploadController {
    @Autowired
    private AliOSSUtils aliOSSUtils;
    @Autowired
    private UserService userService;
    /*
    * 上传文件文件
    * 更新数据库*/
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        log.info("文件上传{}",image.getOriginalFilename());
        //调用阿里云oss上传文件
        String url = aliOSSUtils.upload(image);
        //System.out.println(url);
        log.info("文件上传完成url：{}",url);
        //获取token内携带的用户
        String username = BaseContext.getCurrentName();
        User user=userService.meassage(username);
        //System.out.println(user);
        Long id=user.getId();
        //创建新的用户，用于更新数据
        User request=new User();
        BeanUtils.copyProperties(user,request);
        request.setImage(url);
        request.setUpdateTime(LocalDateTime.now());
        //System.out.println(request);
        //执行更新并返回当前头像链接
        userService.update(request);
        return Result.success(url);
    }
}
