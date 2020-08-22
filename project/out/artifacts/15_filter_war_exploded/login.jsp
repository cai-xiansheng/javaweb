<%--
  Created by IntelliJ IDEA.
  User: 张辉
  Date: 2020/8/23
  Time: 0:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
login.jsp

<form action="http://localhost:8080/15_filter/loginServlet" method="get">
    用户名：<input type="text" name="username"/><br>
    密 码：<input type="password" name="password"><br>
    <input type="submit" value="登录">

</form>
</body>
</html>
