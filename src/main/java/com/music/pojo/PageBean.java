package com.music.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/*
* 分页查询封装*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageBean implements Serializable {
    private Long total;//分页总数
    private List rows;//数据列表
}
