package com.music.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.music.context.BaseContext;
import com.music.pojo.Result;
import com.music.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@Slf4j
@SpringBootApplication
public class LoginCheckIntercepter implements HandlerInterceptor {
    private static final String signKey = "music";
    public static String jwt;
    @Override//运行前运行true放行，false拦截
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        //获取请求参数
        String url = req.getRequestURI();
        log.info("url:{}",url);
        //判断url
        if (url.contains("login")){
            log.info("登录操作");
            return true;
        }
        if (url.contains("registr")){
            log.info("注册操作");
            return true;
        }
        if(url.contains("doc")){
            return true;
        }
        if(url.contains("favicon")){
            return true;
        }
        if(url.contains("webjars")){
            return true;
        }
        if(url.contains("swagger")){
            return true;
        }
        if (!req.getMethod().equals("OPTIONS")) {
            //获取请求头
            jwt = req.getHeader("Authorization");
            //判断jwt存在
            //log.info("这是前端的token:{}",jwt);
            if (!StringUtils.hasLength(jwt)){
                log.info("token不存在");
                Result error=Result.error("NOT_LOGIN");
                //转换数据--->阿里巴巴
                String jsonString = JSONObject.toJSONString(error);
                resp.getWriter().write(jsonString);
                return false;
            }
            //解析jwt令牌
            try {
                JwtUtils.parseJWT(jwt);
                Claims claims = Jwts.parser()
                        .setSigningKey(signKey)
                        .parseClaimsJws(jwt)
                        .getBody();
                //获取当前请求的token的用户名
                String username = (String) claims.get("username");
                //放入线程
                BaseContext.setCurrentName(username);
                //获取当前id
                Integer ids = (Integer) claims.get("id");
                log.info("这是用户id{}",ids);
                //放入线程
                Long id=ids.longValue();
                BaseContext.setCurrentId(id);
                //打印测试
                log.info("测试：{}",BaseContext.getCurrentId());
            } catch (Exception e) {
                e.printStackTrace();
                log.info("解析失败！");
                Result error=Result.error("NOT_LOGIN");
                //转换数据--->阿里巴巴
                String jsonString = JSONObject.toJSONString(error);
                resp.getWriter().write(jsonString);
                return false;
            }
       }
        //放行
        log.info("合法，放行");
        return true;
    }

    @Override//运行后运行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("......");
    }

    @Override//最后运行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("-------");
    }
}
