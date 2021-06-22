package com.like.web.filter;


import com.like.domain.Admin;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 获得在下面代码中要用的request,response,session对象
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();
        //设置全局编码
        servletRequest.setCharacterEncoding("utf-8");
        //servletResponse.setCharacterEncoding("utf-8");
        //servletResponse.setContentType("text/html;charset=utf-8");

        // 获得用户请求的URI
        String path = servletRequest.getRequestURI();
        // 这些请求和页面无需过滤
        if(path.indexOf("/NewsInfor") > -1 || path.indexOf("/searchNews") > -1 ||
           path.indexOf("/getInformation") > -1 || path.indexOf("/login")> -1 ||
           path.indexOf("/css") > -1) {
            chain.doFilter(servletRequest, servletResponse);
            return;
        }
        else if (path.indexOf("/login.jsp") > -1 || path.indexOf("/index.jsp") > -1 ||
                 path.indexOf("/search.jsp") > -1 || path.indexOf("/info.jsp") > -1){
            chain.doFilter(servletRequest, servletResponse);
            return;
        }

        //判断当前是否已登录（未登录跳转到登录页面）
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin == null){
            System.out.println("过滤器拦截：当前未登录");
            servletResponse.sendRedirect("/login.jsp");
        }
        else {      //已登录，放行
            chain.doFilter(servletRequest, servletResponse);
            return;
        }

    }

    @Override
    public void destroy() {

    }
}
