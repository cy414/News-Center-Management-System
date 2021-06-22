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

        <div class="main">
   
            <table border="0">
                <tr>
                    <th>新闻标题</th>
                    <th>新闻作者</th>
                    <th>新闻类型</th>
                    <th>发布时间</th>
                </tr>
                <%
                    List<NewInfor> list = (List<NewInfor>) session.getAttribute("list");
                    for (int i=0; i<list.size(); i++){
                        NewInfor newInfor = list.get(i);
                %>
                <tr>
                    <td>
                        <a href="getInformation?newsId=<%=newInfor.getId()%>"><%= newInfor.getTitle()%></a>
                    </td>
                    <td><%= newInfor.getAuthor()%></td>
                    <td><%= newInfor.getType()%></td>
                    <td><%= newInfor.getTime()%></td>
                </tr>
                <% } %>
            </table>
        </div>
    </div>
</body>

</html>