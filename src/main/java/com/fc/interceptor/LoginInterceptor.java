package com.fc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: T21
 * @date: 2022/5/8.
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     *
     * @return 拦截器执行之前执行,返回值为false代表被拦截了，如果是true说明放行
     *
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //从域对象中获取用户的信息和权限
        Object user = request.getSession().getAttribute("user");
        Object userType = request.getSession().getAttribute("userType");

        //如果用户信息和权限不为空就放行
        if (user != null && userType != null) {

            return true;
        }

        response.sendRedirect(request.getContextPath() + "/login.html");

        return false;
    }
}
