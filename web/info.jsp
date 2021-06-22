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
                <a class="left1 a1" href="/NewsInfor">所有新闻</a>
                <a class="left2 a1" href="search.jsp">搜索新闻</a>
                <a class="left2 a1" href="/getUserNews">后台管理</a>
            </span>
        </div>
        <hr>

        <div class="main" style="text-align: left;">
            <table border="0">
                <%
                    NewInfor newsInfo = (NewInfor) session.getAttribute("news");
                %>
                <tr>
                    <td>新闻标题</td>
                    <td><%=newsInfo.getTitle()%></td>
                </tr>
                <tr>
                    <td>新闻类型</td>
                    <td><%=newsInfo.getType()%></td>
                </tr>
                <tr>
                    <td>新闻作者</td>
                    <td><%=newsInfo.getAuthor()%></td>
                </tr>
                <tr>
                    <td>新闻内容</td>
                    <td style="width: 85%;">
                        <div style="width:100%;height: auto;word-break: break-all;word-wrap: break-word;line-height:20px; ">
                            <%=newsInfo.getContent()%>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>发布时间</td>
                    <td><%=newsInfo.getTime()%></td>
                </tr>
            </table>
        </div>
    </div>
</body>

</html>