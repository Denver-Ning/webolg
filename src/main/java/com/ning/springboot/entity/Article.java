package com.ning.springboot.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Article {
    private Integer id;
    private Integer userId;
    private Integer tagId;
    private Integer categoryId;
    private String title;
    private String content;
    private String coverImg;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
