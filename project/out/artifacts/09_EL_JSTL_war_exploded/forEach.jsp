<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="com.zh.pojo.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 张辉
  Date: 2020/8/15
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--
    1. 遍历1到10输出
    begin属性设置开始的索引
    end属性设置结束的缩影
    var属性表示遍历的变量(也是当前正在遍历到的数据)
    for(int i = 1; i < 10; i++)
--%>
<table border="1">
    <c:forEach begin="1" end="10" var="i">
        <tr>
            <td>第${i}行</td>
        </tr>
    </c:forEach>
</table>
<hr>

<%--
    2. 遍历Object数组
    for(Object object:objects)
    items表示遍历的数据源（遍历的集合）
    var表示当前遍历到的数据
--%>
<%
    request.setAttribute("arr", new String[]{"12431414", "15151651", "1515616"});
%>
<c:forEach items="${requestScope.arr}" var="item">
    ${ item }<br>
</c:forEach>
<hr>

<%--
    3.遍历Map集合
--%>
<%
    Map<String, Object> map = new HashMap<>();
    map.put("key1", "value1");
    map.put("key2", "value2");
    map.put("key3", "value3");
    for (Map.Entry<String, Object> entry : map.entrySet()) {
    }
    request.setAttribute("map", map);
%>
<c:forEach items="${requestScope.map}" var="entry">
    ${entry} ${entry.key} --- ${entry.value}<br>
</c:forEach>
<hr>

<%--
    4. 遍历List集合---list中存放Student类，有属性：编号，用户名，密码，年龄，电话信息。
--%>
<%
    List<Student> studentList = new ArrayList<>();
    for (int i = 1; i <= 10; i++) {
        studentList.add(new Student(i, "username" + i, "password" + i, 15 + i, "145151phone" + i));
    }
    request.setAttribute("studentList", studentList);
%>
<table border="1">
    <thead>
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>密码</td>
        <td>年龄</td>
        <td>电话</td>
        <td>操作</td>
    </tr>
    </thead>
    <tbody>
    <%--
        items表示遍历的集合
        var表示遍历到的数据
        begin表示遍历的开始索引值
        end表示结束的索引值
        step属性表示遍历的步长值
        varStatus 属性表示当前遍历到的数据的状态
        for(int i = 0; i < 10; i+=2) {

        }
    --%>
    <c:forEach begin="0" end="7" items="${requestScope.studentList}" var="student" varStatus="status">
        <%--${student}<br>--%>
        <tr>
            <td>${student.id}</td>
            <td>${student.username}</td>
            <td>${student.password}</td>
            <td>${student.age}</td>
            <td>${student.phone}</td>
            <td>${status}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>




</body>
</html>
