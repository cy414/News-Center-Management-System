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

@WebServlet(name = "edit", value = "/edit")
public class Edit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        NewsService newsService = new NewsService();
        HttpSession session = request.getSession();
        //获取参数
        String title = request.getParameter("title");
        String type = request.getParameter("type");
        String author = request.getParameter("author");
        String content = request.getParameter("content");

        //更新文章
        int rs = newsService.update(title, type, author, content);
        if (rs > 0){
            //更新成功，跳转回展示用户所写的文章界面
            request.getRequestDispatcher("/getUserNews").forward(request, response);
            session.setAttribute("updateStatus", null);
        }
        else {
            session.setAttribute("updateStatus", "更新失败！");
        }
    }
}
