package com.music.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomePageVO implements Serializable {
    @Serial
    private static final long serialVersionUID = -1703266876801996381L;
    private String username;
    private String image;
    private List rows;//数据列表

}
