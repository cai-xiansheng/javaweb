<%--
  Created by IntelliJ IDEA.
  User: 张辉
  Date: 2020/8/20
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
      <base href="http://localhost:8080/temp/">
  </head>
  <body>
    <form action="registerServlet" method="get">
        用户名：<input type="text" name="username"><br/>
        验证码：<input type="text" name="code" style="width: 60px;">
        <img style="width: 100px; height: 28px;margin-top: 10px;" src="http://localhost:8080/temp/kaptcha.jpg" alt="code"><br>
        <input type="submit" value="登录">
    </form>
  </body>
</html>
