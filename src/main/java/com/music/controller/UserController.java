package com.music.controller;

import com.music.context.BaseContext;
import com.music.pojo.Result;
import com.music.pojo.User;
import com.music.service.UserService;
import com.music.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
//@RequestMapping("/user")
@Api(tags = "用户信息展示")
public class UserController {
    private static final String signKey = "music";
    @Autowired
    private UserService userService;
    @GetMapping("/userInfo")
    public Result userInfo(){
        String username = BaseContext.getCurrentName();
        User user=userService.meassage(username);
        return Result.success(user);
    }
}
