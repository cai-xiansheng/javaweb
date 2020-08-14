<%--
  Created by IntelliJ IDEA.
  User: 张辉
  Date: 2020/8/14
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>scope.jsp页面</h1>
    pageContext域是否有值：<%=pageContext.getAttribute("key")%><br>
    request域是否有值：<%=request.getAttribute("key")%><br>
    session域是否有值：<%=session.getAttribute("key")%><br>
    application域是否有值：<%=application.getAttribute("key")%><br>

</body>
</html>
