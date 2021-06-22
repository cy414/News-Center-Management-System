<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
            <form action="add" method="post">
                新闻标题：
                <input name="title" class="inp1" type="text">
                <br>
                新闻类型：
                <input name="type" class="inp1" type="text">
                <br>
                新闻作者：
                <input name="author" class="inp1" type="text">
                <br>
                新闻内容：
                <br>
                <textarea name="content" id="" cols="65" rows="10"></textarea>
                <br>
                <input style="width: 98%;" value="添加" type="submit">
            </form>
            <h4 style="color: red">${insertStatus}</h4>
        </div>
    </div>
</body>

</html>