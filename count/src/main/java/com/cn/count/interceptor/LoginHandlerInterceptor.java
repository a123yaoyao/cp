package com.cn.count.interceptor;

import com.cn.count.model.User;
import com.cn.count.service.UserService;

import com.cn.count.utils.CookieUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {

    public static final String COOKIE_NAME = "USER_TOKEN";
    Logger logger = LoggerFactory.getLogger(LoginHandlerInterceptor.class);
    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String token = CookieUtils.getCookieValue(request, COOKIE_NAME);
        logger.info("------USER_TOKEN------" + token);
        User user = userService.getUserByToken(token);
        //判断用户ID是否存在，不存在就跳转到登录界面
        if (StringUtils.isEmpty(token) ||null == user) {
            // 跳转到登录页面，把用户请求的url作为参数传递给登录页面。
            logger.info("------:跳转到单点的登陆 login页面！");
            response.sendRedirect("http://localhost:8081/login?redirect=" + request.getRequestURL());
            return false;
        } else {
            // 把用户信息放入Request
            request.setAttribute("user", user);
            // 返回值决定handler是否执行。true：执行，false：不执行。
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }


}
