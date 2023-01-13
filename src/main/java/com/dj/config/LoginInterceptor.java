package com.dj.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        //放行：判断什么情况下登录

        //登录页面也会放行
        if (request.getRequestURI().contains("goLogin")){
            return  true;
        }

        //第一次登录问题，没有设置成功session
        //说明我在提交登录
        if (request.getRequestURI().contains("login")){
            return true;
        }

        //登录了也放行
        if (session.getAttribute("userLoginInfo")!=null){
            return true;
        }else {
            //判断什么情况下没有登录
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        }

        return false;
    }
}
