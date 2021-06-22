package com.like.web;

import com.like.service.NewsService;
import util.DBUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "delete", value = "/delete")
public class Delete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newsId = request.getParameter("id");
        Integer id = Integer.valueOf(newsId);
        HttpSession session = request.getSession();
        NewsService newsService = new NewsService();

        //删除文章
        newsService.deleteNews(id);
        //查询所有文章，打开页面展示
        request.getRequestDispatcher("/getUserNews").forward(request, response);
    }
}
