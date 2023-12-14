package com.ning.springboot.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Category {
    private Integer id;
    private String categoryName;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
