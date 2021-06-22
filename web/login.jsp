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

        <div class="main">
            <form action="login" method="post">
                <h3>管理员登录</h3>
                <br>
                管理员账号：
                <input name="username" type="text">
                <br>
                管理员密码：
                <input name="password" type="password">
                <br><br>
                <input style="width: 265px;" type="submit" value="登录">
            </form>
            <br>
            <h4 style="color: red">${status}</h4>
        </div>
    </div>
</body>

</html>