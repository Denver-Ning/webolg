package com.ning.springboot.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BlogSetting {
    private Integer id;
    private Integer userId;
    private String blogName;
    private String authorName;
    private String authorAvatar;
    private String desc;
    private String githubUrl;
    private Integer githubSwitch;
    private String giteeUrl;
    private Integer giteeSwitch;
    private Integer nuggetsSwitch;
    private String nuggetsUrl;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorAvatar() {
        return authorAvatar;
    }

    public void setAuthorAvatar(String authorAvatar) {
        this.authorAvatar = authorAvatar;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    public Integer getGithubSwitch() {
        return githubSwitch;
    }

    public void setGithubSwitch(Integer githubSwitch) {
        this.githubSwitch = githubSwitch;
    }

    public String getGiteeUrl() {
        return giteeUrl;
    }

    public void setGiteeUrl(String giteeUrl) {
        this.giteeUrl = giteeUrl;
    }

    public Integer getGiteeSwitch() {
        return giteeSwitch;
    }

    public void setGiteeSwitch(Integer giteeSwitch) {
        this.giteeSwitch = giteeSwitch;
    }

    public Integer getNuggetsSwitch() {
        return nuggetsSwitch;
    }

    public void setNuggetsSwitch(Integer nuggetsSwitch) {
        this.nuggetsSwitch = nuggetsSwitch;
    }

    public String getNuggetsUrl() {
        return nuggetsUrl;
    }

    public void setNuggetsUrl(String nuggetsUrl) {
        this.nuggetsUrl = nuggetsUrl;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
