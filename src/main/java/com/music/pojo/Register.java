package com.music.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Register implements Serializable {
    private String username;
    private String password;
    private Integer gender;
    private String email;
    private String phone;
}
