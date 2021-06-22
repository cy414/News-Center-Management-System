<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.like.domain.NewInfor" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/globalCss.css">
    <title>所有新闻</title>
</head>

<body>
    <div class="container">
        <div class="top">
            <h1>新闻管理系统</h1>
        </div>
        <div class="banner">
            <span>
                <a class="left3 a1" href="/NewsInfor">所有新闻</a>
                <a class="left2 a1" href="add.jsp">添加新闻</a>
                <a class="left2 a1" href="login.jsp">系统登录</a>
                <a class="left2 a1" href="/NewsInfor">新闻主页</a>
            </span>
        </div>
        <hr>

        <div class="main1">
            <form action="edit" method="post">
                <%
                    NewInfor newsInfo = (NewInfor) session.getAttribute("news");
                %>
                新闻标题：
                <input class="inp1" name="title" type="text" value="<%=newsInfo.getTitle()%>">
                <br>
                新闻类型：
                <input class="inp1" name="type" type="text" value="<%=newsInfo.getType()%>">
                <br>
                新闻作者：
                <input class="inp1" name="author" type="text" value="<%=newsInfo.getAuthor()%>">
                <br>
                新闻内容：
                <br>
                <textarea name="content" id="" cols="65" rows="10"><%=newsInfo.getContent()%></textarea>
                <br>
                发布时间：<%=newsInfo.getTime()%>
                <input style="width: 98%;" type="submit" value="更新文章">
            </form>
            <h4 style="color: red">${updateStatus}</h4>
        </div>
    </div>
</body>

</html>