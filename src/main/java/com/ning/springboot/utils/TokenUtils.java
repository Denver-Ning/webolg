package com.ning.springboot.utils;

import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.util.Date;
public class TokenUtils {
    /**
     * 生成token
     *
     */
    public static String getToken(String userId, String sign) {
       return JWT.create().withAudience(userId)
               .withExpiresAt(DateUtil.offsetDay(new Date(), 1)) // 设置过期时间为1天
               .sign(Algorithm.HMAC256(sign));
    }

}
