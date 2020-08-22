<%--
  Created by IntelliJ IDEA.
  User: 张辉
  Date: 2020/8/23
  Time: 0:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Object user = session.getAttribute("user");
        // 如果等于null。则说明没有登陆
        if (user == null) {
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    %>
    我是a.jsp文件
</body>
</html>
