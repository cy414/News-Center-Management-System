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

/*
* 加载新闻详细内容
* */
@WebServlet(name = "getInformation", value = "/getInformation")
public class GetInformation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        NewInfor newsInfor;
        String openPage = null;
        NewsService newsService = new NewsService();
        //接收参数
        String newsId = request.getParameter("newsId");
        String editId = request.getParameter("editId");

        //判断获取文章后的下一步是否编辑文章
        Integer id = null;
        if (newsId != null && !newsId.equals("")){
            id = Integer.valueOf(newsId);
            openPage = "/info.jsp";
        } else {
            id = Integer.valueOf(editId);
            openPage = "/edit.jsp";
        }
        //根据id获取文章内容
        newsInfor = newsService.getNewsById(id);
        //将结果存到session中
        session.setAttribute("news", newsInfor);

        //请求转发(跳转页面)
        request.getRequestDispatcher(openPage).forward(request,response);
    }
}
