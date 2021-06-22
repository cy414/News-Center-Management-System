package com.like.web;

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

@WebServlet(name = "searchNews", value = "/searchNews")
public class SearchNews extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        NewsService newsService = new NewsService();
        HttpSession session = request.getSession();
        List<NewInfor> list;
        //获取参数
        String keyword = request.getParameter("keyword");
        keyword = "%"+keyword+"%";

        //根据关键字搜索所有新闻的标题
        list = newsService.searchNews(keyword);
        //将结果存到session中
        session.setAttribute("searchlist", list);

        //请求转发(跳转页面)
        request.getRequestDispatcher("/search.jsp").forward(request,response);
    }
}
