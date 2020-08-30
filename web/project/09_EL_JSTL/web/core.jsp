<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 张辉
  Date: 2020/8/15
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
    作用：set标签可以往域中保存数据

    域对象.setAttribute(key,value);
    scope属性设置保存到哪个域
        page表示PageContext域（默认值）
        request表示Request域
        session表示Session域
        application表示ServletContext域
    var属性设置key是多少
    value属性设置值是多少
--%>
保存之前：${pageScope.abc}<br>
<c:set scope="page" var="abc" value="cssfs"/>
保存之后：${pageScope.abc}<br>


<%--
    <c:if/>
    if标签用来做if判断。
    test属性表示判断的条件（使用EL表达式输出）
--%>

<c:if test="${ 12 == 12}">
    <h1>12==12</h1>
</c:if>
<c:if test="${ 12 != 12}">
    <h1>12!=12</h1>
</c:if>

<%--
    <c:choose><c:when><c:otherwise>标签
    作用：多路判断。跟switch...case...default非常接近

    choose标签开始选择判断
    when表示每一种判断情况
        test表示当前判断情况的值
    otherwise表示其他情况
    <c:choose><c:when><c:otherwise>变迁使用时需要注意的点：
        1. 标签里不能使用html注释，要使用jsp注释
        2. when标签的父标签一定要使用choose标签
--%>
<%
    request.setAttribute("height", 150);
%>
<c:choose>
    <c:when test="${ requestScope.height > 190}">
        <h2>小巨人</h2>
    </c:when>
    <c:when test="${ requestScope.height > 180}">
        <h2>很高</h2>
    </c:when>
    <c:when test="${ requestScope.height > 170}">
        <h2>还可以</h2>
    </c:when>
    <c:otherwise>
        <c:choose>
            <c:when test="${ requestScope.height > 160}">
                <h2>大于160</h2>
            </c:when>
            <c:when test="${ requestScope.height > 150}">
                <h2>大于150</h2>
            </c:when>
            <c:when test="${ requestScope.height > 140}">
                <h2>大于140</h2>
            </c:when>
        </c:choose>
    </c:otherwise>
</c:choose>




</body>
</html>
