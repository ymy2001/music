package com.music.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoveMusicVO implements Serializable {
    private Long userId;//用户id
    private Long id;//音乐id
    private String musicName;//音乐名
    private String musicSinger;//音乐歌唱人
    private Integer musicType;//类型分为4类 1.代表古风 2.代表电音 3.代表流行 4.代表乡村
    private String musicText;//歌词
    private String imageUrl;//图片路径
    private String musicUrl;//音乐路径
}

