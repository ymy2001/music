package com.music.mapper;

import com.music.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    /*
     * 登录验证*/
    @Select("select * from user where username=#{username} and password=#{password}")
    User getByIdAndName(User user);

    /*
    * 查找用户*/
    @Select("select * from user where username=#{name}")
    User getByname(String name);

    /*
    * 用户注册*/
    @Insert("insert into user(username, password, gender, email, phone, image,create_time,update_time)" +
            "            values (#{username},#{password},#{gender},#{email}," +
            "                   #{phone},#{image},#{createTime},#{updateTime})")
    void insert(User user);

    /*
    * 更新用户数据*/
    void update(User user);
}
