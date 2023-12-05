package com.ning.springboot.utils;

import com.ning.springboot.common.LoginUser;

/**
 * @author Syp ･◡･
 * @date 2023/12/5
 */
public class UserUtils {
    private static final ThreadLocal<LoginUser> USER_CONTEXT = new ThreadLocal<>();

    /**
     * 获取用户id
     * @return  用户id
     */
    public static String  getUserId(){
        LoginUser loginUser = getLoginUser();
        if (loginUser == null) {
            return null;
        }
        return loginUser.getUserId();
    }

    /**
     * 获取登陆用户信息 方便以后拓展
     * @return  用户信息
     */
    private static LoginUser getLoginUser(){
        return USER_CONTEXT.get();
    }

    /**
     * 设置用户上下文信息
     * @param loginUser 用户信息
     */
    public static void setUserContext(LoginUser loginUser){
        LoginUser userContext = USER_CONTEXT.get();
        if (userContext == null) {
            USER_CONTEXT.set(loginUser);
        }
    }

    public static void clearThreadLocal() {
        USER_CONTEXT.remove();
    }
}