<%--
  Created by IntelliJ IDEA.
  User: 张辉
  Date: 2020/8/16
  Time: 1:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/" ;
    pageContext.setAttribute("basePath",basePath);
%>


<!--些base标签，永远固定相对路径跳转的结果-->
<base href="<%=basePath%>"/>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>