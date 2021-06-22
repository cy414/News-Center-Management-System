package com.like.web;

import com.like.domain.Admin;
import com.like.domain.NewInfor;
import com.like.service.NewsService;
import util.DBUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "getUserNews", value = "/getUserNews")
public class GetUserNews extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从session获取出当前用户
        HttpSession session = request.getSession();
        Admin admin = (Admin)session.getAttribute("admin");
        NewsService newsService = new NewsService();

        //查询当前用户的文章
        List<NewInfor> list = newsService.getNewsByUserName(admin.getAdminname());
        session.setAttribute("list", list);

        //重定向
        response.sendRedirect("/management.jsp");
    }
}
