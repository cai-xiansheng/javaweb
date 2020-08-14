<%@ page import="com.zh.pojo.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 张辉
  Date: 2020/8/14
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Person person = new Person();
        person.setName("张三");
        person.setPhones(new String[]{"14124141", "132141"});
        List<String> cities = new ArrayList<>();
        cities.add("上海");
        cities.add("上海c");
        cities.add("上");
        cities.add("海");
        person.setCities(cities);
        Map<String,Object> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        person.setMap(map);
        pageContext.setAttribute("person",person);
    %>
    输出的Person:${person}<br>
    输出的Person的name属性:${person.name}<br>
    输出的Person的phones数组属性:${person.phones[0]}<br>
    输出的Person的List集合中的元素值:${person.cities}<br>
    输出的Person的List集合中个别元素值:${person.cities[1]}<br>
    输出的Person的Map集合:${person.map}<br>
    输出的Person的Map集合中某个key的值:${person.map.key1}<br>
    输出的Person的age属性:${person.age}<br>
</body>
</html>
