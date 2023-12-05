package com.ning.springboot.controller.dto;

import lombok.Data;

/**
 * 前端传输的参数
 */
@Data
public class userDto {
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String token;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
