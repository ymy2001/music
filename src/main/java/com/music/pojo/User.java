package com.music.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
/*
* 用户实体类*/
public class User {
    private Long id;
    private String username;
    private String password;
    private Integer gender;
    private String email;
    private String phone;
    private String image;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
