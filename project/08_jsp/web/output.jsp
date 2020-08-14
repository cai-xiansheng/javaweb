<%--
  Created by IntelliJ IDEA.
  User: 张辉
  Date: 2020/8/14
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        out.write("out输出1 <br>");
        out.flush();
        out.write("out输出2 <br>");

        response.getWriter().write("response输出1 <br>");
        response.getWriter().write("response输出2 <br>");
    %>
</body>
</html>
