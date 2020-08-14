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

![image-20200815001832255](C:\Users\张辉\Desktop\javaweb\notes\EL表达式&JSTL标签库.assets\image-20200815001832255.png)

### 逻辑运算

![image-20200815001841206](C:\Users\张辉\Desktop\javaweb\notes\EL表达式&JSTL标签库.assets\image-20200815001841206.png)

### 算术运算

![image-20200815001859649](C:\Users\张辉\Desktop\javaweb\notes\EL表达式&JSTL标签库.assets\image-20200815001859649.png)

![image-20200815001910077](C:\Users\张辉\Desktop\javaweb\notes\EL表达式&JSTL标签库.assets\image-20200815001910077.png)

### empty运算

empty运算可以判断一个数据是否为空，如果为空，则输出true，不为空输出false。

以下集中情况为空：

1. 值为null值的时候，为空
2. 值为空串的时候，为空
3. 值是Object类型数组，长度为0的时候
4. List集合，元素个数为0
5. Map集合，元素个数为0

![image-20200815004730319](C:\Users\张辉\Desktop\javaweb\notes\EL表达式&JSTL标签库.assets\image-20200815004730319.png)

### 三元运算

==${ 12 != 12 ? "真" : "假"}==

### “.”点运算和[]中括号运算符

.运算符，可以输出Bean对象中某个属性的值。

[]中括号运算，可以输出有序集合中某个元素的值。

并且[]中括号运算，还可以输出**map集合**中key里含有特殊字符的key的值。

![image-20200815004848844](C:\Users\张辉\Desktop\javaweb\notes\EL表达式&JSTL标签库.assets\image-20200815004848844.png)

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

![image-20200815011203525](C:\Users\张辉\Desktop\javaweb\notes\EL表达式&JSTL标签库.assets\image-20200815011203525.png)

### pageContext对象的使用

1. 协议
2. 服务器ip
3. 服务器端口
4. 获取工程路径
5. 获取请求方法
6. 获取客户端ip地址
7. 获取会话的id编号

![image-20200815011609366](C:\Users\张辉\Desktop\javaweb\notes\EL表达式&JSTL标签库.assets\image-20200815011609366.png)

![image-20200815011632779](C:\Users\张辉\Desktop\javaweb\notes\EL表达式&JSTL标签库.assets\image-20200815011632779.png)

### EL表达式其他隐含对象的使用

![image-20200815012345715](C:\Users\张辉\Desktop\javaweb\notes\EL表达式&JSTL标签库.assets\image-20200815012345715.png)

![image-20200815012428253](C:\Users\张辉\Desktop\javaweb\notes\EL表达式&JSTL标签库.assets\image-20200815012428253.png)

