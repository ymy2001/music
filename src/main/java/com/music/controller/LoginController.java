package com.music.controller;

import com.music.pojo.Register;
import com.music.pojo.Result;
import com.music.pojo.User;
import com.music.service.UserService;
import com.music.utils.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
//@RequestMapping("/user")
@Api(tags = "登录注册接口")
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation("“用户登录")
    public Result login(@RequestBody User user){
        log.info("用户登录{}",user);
        User e=userService.login(user);
        //登录成功下发令牌
        if (e!=null){
            Map<String, Object> claims=new HashMap<>();
            claims.put("phone",e.getPhone());
            claims.put("id",e.getId());
            claims.put("username",e.getUsername());
            String jwt = JwtUtils.generateJwt(claims);//当前员工信息
            System.out.println(jwt);
            return Result.success(jwt);
        }
        return Result.error("用户名或密码错误");
    }
    @ApiOperation("用户注册")
    @PostMapping("/register")
    public Result register(@RequestBody User user){
        log.info("用户注册{}",user);
        String name=user.getUsername();
        User user_name=userService.register(name);
        log.info("查询到的用户{}",user_name);
        if (user_name==null){
            userService.insert(user);
            //System.out.println(user);
            return Result.success();
        }
        return Result.error("用户存在");
    }
}
