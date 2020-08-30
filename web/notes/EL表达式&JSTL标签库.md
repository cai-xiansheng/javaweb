# EL表达式

## 什么是EL表达式，EL表达式的作用？

EL表达式的全称是：Exception Language。是表达式语言。

EL表达式的作用：EL表达式主要代替jsp页面中的表达式脚本在jsp页面中进行数据的输出。

因为EL表达式在输出数据的时候，要比jsp的表达式脚本要简洁很多。

```jsp
<body>
    <%
        request.setAttribute("key", "值");
    %>
    表达式脚本输出key的值是：<%=request.getAttribute("key1")==null ? "" : request.getAttribute("key1")%><br>
    EL表达式输出key的是：${key1}
</body>
```

EL表达式的格式是：`${表达式}`

EL表达式在输出null值的时候，输出的是空串。jsp表达式脚本输出null的时候，输出的是null字符串。

## EL表达式搜索域数据的顺序

EL表达式主要是在jsp页面中输出数据。

主要是输出域对象中的数据。



当四个域中都有相同的key的数据的时候，EL表达式会按照四个域的从小到大的顺序去进行搜索，找到就输出。

```jsp
<body>
    <%
        // 往四个域中都保存了相同的key的数据。
        pageContext.setAttribute("key","pageContext");
        request.setAttribute("key","request");
        session.setAttribute("key","session");
        application.setAttribute("key","application");
    %>
    ${key}
</body>
```

jsp四个域在使用的时候，优先顺序分别是，他们**从小到大的范围**的顺序。

`pageContext  ===>>>  request  ===>>>  session  ===>>>  application`

## EL表达式输出Bean的普通属性，数组属性，List集合属性，Map集合属性

需求——输出Person类中普通属性，数组属性。List集合属性和Map集合属性。

Person类

```java
public class Person {
    private String name;
    private String[] phones;
    private List<String> cities;
    private Map<String, Object> map;
    
    public int getAge() {
        return 19;
    }
}
```

输出的代码

```jsp
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
```

## EL表达式——运算

> 语法：${运算表达式}，EL表达式支持如下运算符：

### 关系运算

![image-20200815001832255](EL表达式&JSTL标签库.assets\image-20200815001832255.png)

### 逻辑运算

![image-20200815001841206](EL表达式&JSTL标签库.assets\image-20200815001841206.png)

### 算术运算

![image-20200815001859649](EL表达式&JSTL标签库.assets\image-20200815001859649.png)

![image-20200815001910077](EL表达式&JSTL标签库.assets\image-20200815001910077.png)

### empty运算

empty运算可以判断一个数据是否为空，如果为空，则输出true，不为空输出false。

以下集中情况为空：

1. 值为null值的时候，为空
2. 值为空串的时候，为空
3. 值是Object类型数组，长度为0的时候
4. List集合，元素个数为0
5. Map集合，元素个数为0

![image-20200815004730319](EL表达式&JSTL标签库.assets\image-20200815004730319.png)

### 三元运算

==${ 12 != 12 ? "真" : "假"}==

### “.”点运算和[]中括号运算符

.运算符，可以输出Bean对象中某个属性的值。

[]中括号运算，可以输出有序集合中某个元素的值。

并且[]中括号运算，还可以输出**map集合**中key里含有特殊字符的key的值。

![image-20200815004848844](EL表达式&JSTL标签库.assets\image-20200815004848844.png)

## EL表达式的11个隐含对象

EL表达式中11个隐含对象，是ELb表达式中自己定义的，可以直接使用。

| 变量             | 类型                  | 作用                                                   |
| ---------------- | --------------------- | ------------------------------------------------------ |
| pageContext      | PageContextImpl       | 它可以获取jsp中的九大内置对象                          |
| pageScope        | Map<String, Object>   | 它可以获取pageContext域中的数据                        |
| requestScope     | Map<String, Object>   | 它可以获取Request域中的数据                            |
| sessionScope     | Map<String, Object>   | 它可以获取session域中的数据                            |
| applicationScope | Map<String, Object>   | 它可以获取ServletContext域中的数据                     |
| param            | Map<String, String>   | 它可以获取请求参数的值                                 |
| paramValues      | Map<String, String[]> | 它也可以获取请求参数的值，获取多个值的时候使用。       |
| header           | Map<String, String>   | 它可以获取请求头的信息                                 |
| headerValues     | Map<String, String[]> | 它可以获取请求头的信息，它可以获取多个值的情况         |
| cookie           | Map<String, Cookie>   | 它可以获取当前请求的 Cookie 信息                       |
| initParam        | Map<String, String>   | 它可以获取在 web.xml 中配置的<context-param>上下文参数 |

### EL获取四个特定域中的属性

| 对象             | 对应的域         |
| ---------------- | ---------------- |
| pageScope        | pageContext域    |
| requestScope     | Request域        |
| sessionScope     | Session域        |
| applicationScope | ServletContext域 |

![image-20200815011203525](EL表达式&JSTL标签库.assets\image-20200815011203525.png)

### pageContext对象的使用

1. 协议
2. 服务器ip
3. 服务器端口
4. 获取工程路径
5. 获取请求方法
6. 获取客户端ip地址
7. 获取会话的id编号

![image-20200815011609366](EL表达式&JSTL标签库.assets\image-20200815011609366.png)

![image-20200815011632779](EL表达式&JSTL标签库.assets\image-20200815011632779.png)

### EL表达式其他隐含对象的使用

![image-20200815012345715](EL表达式&JSTL标签库.assets\image-20200815012345715.png)

![image-20200815012428253](EL表达式&JSTL标签库.assets\image-20200815012428253.png)

# JSTL标签库（次重点）

JSTL标签库全程是指 JSP Standard Tag Library (JSP标准标签库)。是一个不断完善的开放源代码的jsp标签库。

EL表达式主要是为了替换JSP中的表达式脚本，而标签库则是为了替换代码脚本。这样使得整个jsp页面变得更加简洁。

JSTL由五个不同功能的标签库组成。

| 功能范围         | URI                                | 前缀 |
| ---------------- | ---------------------------------- | ---- |
| 核心标签库--重点 | http://java.sun/jsp/jstl/core      | c    |
| 格式化           | http://java.sun/jsp/jstl/fmt       | fmt  |
| 函数             | http://java.sun/jsp/jstl/functions | fn   |
| 数据库（不使用） | http://java.sun/jsp/jstl/sql       | sql  |
| XML(不使用)      | http://java.sun/jsp/hstl/xml       | x    |

在jsp标签库中使用taglib指令引入标签库

+ Core标签库

+ xml标签库
+ FMT标签库
+ SQL标签库
+ FUNCTIONS标签库

```jsp
<%--Core标签库--%>
<%@ taglib prefix="c" uri="http://java.sun/jsp/jstl/core"%>
<%--xml标签库--%>
<%@ taglib prefix="x" uri="http://java.sun/jsp/jstl/xml"%>
<%--FMT标签库--%>
<%@ taglib prefix="fmt" uri="http://java.sun/jsp/jstl/fml"%>
<%--SQL标签库--%>
<%@ taglib prefix="sql" uri="http://java.sun/jsp/jstl/sql"%>
<%--FUNCTIONS标签库--%>
<%@ taglib prefix="fn" uri="http://java.sun/jsp/jstl/functions"%>
```

## JSTL 标签库的使用步骤

1. 先导入jstl标签库的jar包
   + taglibs-standard-impl-1.2.1.jar
   + taglibs-standard-spec-1.2.1.jar
2. 第二步，使用taglib指令引入标签库。

==<%@ taglib prefix="c" uri="http://java.sun/jsp/jstl/core"%>==

## Core核心库使用

### `<c:set/>`(很少使用)

作用：set标签可以往域中保存数据

```jsp
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
```

### `<c:if/>`

if标签用来做if判断。

```jsp
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
```

### `<c:choose><c:when><c:otherwise>`标签

作用：多路判断。跟switch...case...default非常接近

```jsp
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
```

### `<c:forEach/>`

作用：遍历输出使用

1. 遍历1到10输出

```jsp
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
```

2. 遍历Object数组

```jsp
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
```

3. 遍历Map集合

```jsp
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
```

4. 遍历List集合---list中存放Student类，有属性：编号，用户名，密码，年龄，电话信息。

StudentBean

```java
public class Student {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private String phone;

```

jsp

```jsp
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
    <c:forEach begin="0" end="7" items="${requestScope.studentList}" var="student">
        <%--${student}<br>--%>
        <tr>
            <td>${student.id}</td>
            <td>${student.username}</td>
            <td>${student.password}</td>
            <td>${student.age}</td>
            <td>${student.phone}</td>
            <td>修改、删除</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
```

