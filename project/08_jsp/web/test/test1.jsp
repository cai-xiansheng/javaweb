<%--
  Created by IntelliJ IDEA.
  User: 张辉
  Date: 2020/8/14
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--练习一：在jsp页面中输出九九乘法口诀表--%>
    <table border="1" cellspacing="2">
        <caption>九九乘法口诀表</caption>
    <%
        for (int i = 1; i <= 9; i++) {
    %>
        <tr>
    <%
            for (int j = 1; j <= i; j++) {

    %>
            <td><%=j + "*" + i + "=" + i*j%></td>
    <%
            }
    %>
        </tr>
    <%
        }
    %>

    </table>

</body>
</html>
