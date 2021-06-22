package com.like.web;

import com.like.domain.Admin;
import com.like.service.AdminService;
import util.DBUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "login", value = "/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        AdminService adminService = new AdminService();

        //验证账号密码
        String status = adminService.verifyAccount(username, password, session);
        if (status.equals("success")){
            //请求转发(获取当前用户的文章)
            request.getRequestDispatcher("/getUserNews").forward(request,response);
        }else{
            response.sendRedirect("/login.jsp");
        }
    }
}
