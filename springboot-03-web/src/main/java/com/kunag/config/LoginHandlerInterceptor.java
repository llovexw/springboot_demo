package com.kunag.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author luorui
 * @company SCUT
 * @create 2022-05-02-22:11
 */

// 登录拦截
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object loginUser = request.getSession().getAttribute("loginUser");

        //若检查没有登陆权限
        if(loginUser==null){
            request.setAttribute("msg","没有登陆权限");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else {
            // 若有权限则放行
            return true;
        }
    }
}
