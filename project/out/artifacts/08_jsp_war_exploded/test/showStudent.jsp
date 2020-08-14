<%@ page import="java.util.List" %>
<%@ page import="com.zh.pojo.Student" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 张辉
  Date: 2020/8/14
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            border: 1px solid pink;
            /*border-collapse: collapse;*/
        }
        td,th{
            border: 1px solid chartreuse;
            width: 80px;
        }
    </style>
</head>
<body>
<%--练习二：jsp输出一个表格，里边有10个学生的信息--%>
    <%
        List<Student> studentList = (List<Student>) request.getAttribute("studentList");
    %>
    <table>
        <caption>学生信息表</caption>

        <thead>
            <tr>
                <th>id</th>
                <th>name</th>
                <th>age</th>
                <th>iphone</th>
                <th>operation</th>
            </tr>
        </thead>
    <%
        for(Student student: studentList) {
    %>
        <tbody>
            <tr>
                <td><%=student.getId()%></td>
                <td><%=student.getName()%></td>
                <td><%=student.getAge()%></td>
                <td><%=student.getPhone()%></td>
                <td>删除、修改</td>
            </tr>
        </tbody>
    <%
        }
    %>
    </table>

</body>
</html>
