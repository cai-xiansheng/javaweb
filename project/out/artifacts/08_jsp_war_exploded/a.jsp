<%--
  Created by IntelliJ IDEA.
  User: 张辉
  Date: 2020/8/13
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         import="java.util.Map"
         errorPage="/error500.jsp"
         isErrorPage="true"
%>
<%@ page import="java.util.HashMap" %>
<%--
errorPage表示错误后自动跳转去的路径
这个路径一般都是以斜杠打头，她表示请求地址为http://ip:port/工程路径/
映射到代码的web目录
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--+ 声明类属性--%>
<%!
    private Integer id;
    private String name;
    private static Map<String,Object> map;
%>
<%--+ 声明static静态代码块--%>
<%!
    static {
        map = new HashMap<String, Object>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        map.put("key4","value4");
    }
%>
<%--+ 声明类方法--%>
<%!
    public int abc() {
        return 12;
    }
%>
<%--+ 声明内部类--%>
<%!
    public static class A{
        private Integer id = 10;
        private String  abc = "abc";
    }
%>


<%--+ 输出整型--%>
<%=12%>
<%--+ 输出浮点型--%>
<%=12.12%>
<%--+ 输出字符串--%>
<%="我是字符串"%>
<%--+ 输出对象--%>
<%=map%>
<%--<%=request.getCookies()%>--%>


<%--+ 代码脚本——if语句--%>
<%
    int i = 13;
    if (i== 12) {
%>
    <h1>出错</h1>
<%
    } else {
%>
    <h1>出</h1>
<%
    }
%>

<%--+ 代码脚本——for循环语句--%>
<table border="1" cellspacing="2">


<%
    for (int j = 0; 10 > j; j++) {
%>

    <tr>
        <td>第<%=j%>行</td>
    </tr>

<%
    }
%>

</table>
<%--+ 翻译后java文件中**_jspService**方法内的代码都可以写--%>
<%
    String username = request.getParameter("username");
    System.out.println(username);
%>


</body>
</html>
