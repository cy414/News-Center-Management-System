package com.like.web;

import com.like.domain.NewInfor;
import com.like.service.NewsService;
import util.DBUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
* 加载新闻
* */
@WebServlet(name = "NewsInfor", value = "/NewsInfor")
public class NewsInfor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<NewInfor> list;
        NewsService newsService = new NewsService();

        //查询所有新闻
        list = newsService.getAllNews();
        //将结果存到session中
        session.setAttribute("list", list);

        //请求转发(跳转页面)
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
