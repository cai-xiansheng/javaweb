<%--
  Created by IntelliJ IDEA.
  User: 张辉
  Date: 2020/8/13
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         import="java.util.Map"
         errorPage="/error500.jsp"
%>
<%--
errorPage表示错误后自动跳转去的路径
这个路径一般都是以斜杠打头，她表示请求地址为http://ip:port/工程路径/
映射到代码的web目录
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
这是html页面数据
<% int i = 10 / 0; %>
</body>
</html>
