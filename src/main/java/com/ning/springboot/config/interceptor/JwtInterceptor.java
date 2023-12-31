package com.ning.springboot.config.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.ning.springboot.common.Constants;
import com.ning.springboot.common.LoginUser;
import com.ning.springboot.entity.User;
import com.ning.springboot.exception.ServiceException;
import com.ning.springboot.service.IUserService;
import com.ning.springboot.utils.UserUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private IUserService IUserService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)  {
        // 获取请求头中的令牌
        String token = request.getHeader("Authorization");
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        // 判断令牌是否为空
        if (token == null) {
            throw new ServiceException(Constants.CODE_401, "请先登录");
        }

        String userId;
        try {
            userId = JWT.decode(token).getAudience().get(0);
        } catch (Exception e) {
            throw new ServiceException(Constants.CODE_401, "登录已过期");
        }
        // 根据token重的userId查询数据库
        User user = IUserService.getById(userId);
        if (user == null) {
            throw new ServiceException(Constants.CODE_401, "用户不存在");
        }
        // 判断令牌是否合法
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
        try {
            jwtVerifier.verify(token);
        } catch (Exception e) {
            throw new ServiceException(Constants.CODE_403, "登录已过期");
        }
        // 设置用户上下文信息
        LoginUser loginUser = new LoginUser();
        loginUser.setUserId(NumberUtils.toInt(userId));
        UserUtils.setUserContext(loginUser);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        UserUtils.clearThreadLocal();
    }
}
