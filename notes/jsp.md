# jsp

## 什么是jsp

jsp的全程是java server pages。Java的服务器页面。

jsp的主要左右时代替Servlet程序回传页面的数据。

因为Servlet程序回传html页面数据时以减非常繁琐的事情。开发成本和维护成本都极高。

Servlet回传html

```java
public class PringHtml extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 通过响应的回传流回传html页面的数据

        resp.setContentType("text/html;charset=utf-8");

        PrintWriter writer = resp.getWriter();

        writer.write("<!DOCTYPE html>\r\n");
        writer.write("<html lang=\"en\">\r\n");
        writer.write("<head>\r\n");
        writer.write("    <meta charset=\"UTF-8\">\r\n");
        writer.write("    <title>Title</title>\r\n");
        writer.write("</head>\r\n");
        writer.write("<body>\r\n");
        writer.write("      这是html页面数据\r\n");
        writer.write("</body>\r\n");
        writer.write("</html>\r\n");


    }
}
```

jsp回传一个简单的html页面的代码

```jsp
<%--
  Created by IntelliJ IDEA.
  User: 张辉
  Date: 2020/8/13
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    这是html页面数据
</body>
</html>
```

jsp如何访问：

jsp页面和html页面一样，都是存放在web目录下的。访问也跟访问html页面一样。

## jsp的本质是什么

jsp页面的本质上是一个Servlet程序

当我们第一次访问jsp页面的时候。Tomcat服务器会帮我们吧jsp页面翻译成一个java源文件。并且对它及性能编译成==.class==字节码程序。我们打开java源文件不难发现器里面的内容是：

![image-20200813231629779](jsp.assets\image-20200813231629779.png)

我们跟踪源代码发现，HttpJspBase类。他直接继承了HttpServlet类，也就是说，jsp翻译出来的java类，它间接的继承了HttpServlet类。也就是说，翻译出来的是一个Servlet程序。

![image-20200813231838654](jsp.assets\image-20200813231838654.png)

总结：通过翻译的Java源代码我们就可以得到结果：jsp就是Servlet程序。

大家可以去观察翻译出来的Servlet程序的源代码。不难发现，其底层实现，也是通过输出流，把html页面数据回传给客户端。

```java
public final class a_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Title</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    这是html页面数据\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
```

## jsp的三种语法

### jsp头部的page指令

jsp的page指令可以修改jsp页面中一些重要的属性，或者行为。

==<%@ page contentType="text/html;charset=UTF-8" language="java" %>==

| 属性         | 作用                                                         |
| ------------ | ------------------------------------------------------------ |
| language     | 表示jsp翻译后是什么语言文件。暂时支支持Java。                |
| contentType  | 表示jsp返回的数据类型是什么。也就是response.setContentType()参数值 |
| pageEncoding | 表示当前jsp页面文件本身的字符集                              |
| import       | 跟java源代码中一样。用于导包，导类                           |

下面两个属性是给out输出流使用

| 属性      | 作用                                                         |
| --------- | ------------------------------------------------------------ |
| autoFlush | 设置当out输出流缓冲区满了之后，是否自动刷新缓冲区。默认值是true |
| buffer    | 设置out缓冲区的大小，默认是8kb.                              |

| 属性        | 作用                                                         |
| ----------- | ------------------------------------------------------------ |
| errorPage   | 设置当jsp页面运行时出错，自动跳转去的错误页面路径            |
| isErrorPage | 设置当前jsp页面是否是错误信息页面，默认是false。如果是true可以获取异常信息。 |
| session     | 设置访问当前jsp页面，否则会创建HttpSession对象，默认时true   |
| extends     | 设置jsp翻译出来的java类默认继承谁                            |

### jsp中常用脚本

#### 声明脚本（极少使用）

> 声明脚本的格式是：<%!  声明java代码  %>
>
> 作用：可以给jsp翻译出来的java类定义属性和方法甚至是代码块。内部类等。

练习：

+ 声明类属性
+ 声明static静态代码块
+ 声明类方法
+ 声明内部类

代码示例：

```jsp
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
```

声明脚本代码翻译对照

![image-20200814085745740](jsp.assets\image-20200814085745740.png)

#### 表达式脚本（常用）

> 表达式脚本的格式是：<%= 表达式 %>
>
> 表达式脚本的作用是：在jsp页面上输出数据。

表达式脚本的特点：

1. 所有的表达式脚本都会被翻译到`_jspService()`方法中
2. 表达式脚本都会被翻译成为**out.print()**输出到页面上。
3. 由于表达式脚本翻译的内容都在**_jspService()**方法中，所以**_jspService()**方法中的对象都可以直接使用。
4. 表达式脚本中的表达式不能以分号结束。



练习：

+ 输出整型
+ 输出浮点型
+ ### 方案二：BASE64编解码解决火狐浏览器的附件中文名问题(新版本支持第一种方案)

+ 输出对象

```jsp
<%--+ 输出整型--%>
<%=12%>
<%--+ 输出浮点型--%>
<%=12.12%>
<%--+ 输出字符串--%>
<%="我是字符串"%>
<%--+ 输出对象--%>
<%=map%>
```

![image-20200814112955961](jsp.assets\image-20200814112955961.png)

#### 代码脚本

> 代码脚本的格式是：<% java语句 %>
>
> 代码脚本的作用是：可以在jsp页面中，编写我们自己需要的功能（写的是Java语句）。

代码脚本的特点是：

1. 代码脚本翻译之后都在**_jspService()**方法中
2. 代码脚本由于翻译到**_jspService()**方法中，所以在**_jspService()**方法中的现有对象可以直接使用。
3. 还可以由多个代码脚本块组合完成一个完整的java语句。
4. 代码脚本还可以和表达式脚本一起组合使用。在jsp页面上输出数据。



联系：

+ 代码脚本——if语句
+ 代码脚本——for循环语句
+ 翻译后java文件中**_jspService**方法内的代码都可以写

```jsp
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
```

![image-20200814114336571](jsp.assets\image-20200814114336571.png)

![image-20200814115442940](jsp.assets\image-20200814115442940.png)

### jsp的三种注释

#### html注释

<!-- 这是html注释 -->

html注释会被翻译到Java源代码种。在_jspService方法里，以out.writer输出到客户端。

#### java注释

```jsp
<%
	// 单行注释
	/* 多行注释 */
%>
```

java注释会被翻译到java源代码中。

#### jsp注释

<%-- 这是jsp注释 --%>

jsp注释可以注掉，jsp页面中所有代码

## jsp九大内置对象

jsp中的内置对象，是指Tomcat在翻译jsp页面称为Servlet源代码后，内部提供的九大对象，就做内置对象。

![image-20200814155841165](jsp.assets\image-20200814155841165.png)

| 对象        | 说明               |
| ----------- | ------------------ |
| request     | 请求对象           |
| response    | 响应对象           |
| pageContext | jsp上下文对象      |
| session     | 会话对象           |
| application | ServletContext对象 |
| config      | ServletConfig对象  |
| out         | jsp输出流对象      |
| page        | 指向当前jsp对象    |
| exception   | 异常对象           |

## jsp四大域对象

| 对象        | 所属类              | 对象的有效范围                                             |
| ----------- | ------------------- | ---------------------------------------------------------- |
| pageContext | PageContextImpl类   | 当前jsp页面范围内有效                                      |
| request     | HttpServletReques类 | 一次请求内有效                                             |
| session     | HttpSessopn类       | 一个会话范围内有效（打开浏览器访问服务器，直到关闭浏览器） |
| application | ServletContext类    | 整个web工程范围内都有效（只要web工程不停止，数据都在）     |

域对象是可以像Map一样存取数据的对象。四个域对象功能一样。不同的是他们对数据的存取范围。

虽然四个域对象都可以存取数据。在使用上他们是有优先顺序的，

四个域在使用的时候，优先顺序分别是，他们**从小到大的范围**的顺序。

`pageContext  ===>>>  request  ===>>>  session  ===>>>  application`

scope.jsp页面

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>scope.jsp页面</h1>
    <%
        // 往四个域中分别保存了数据
        pageContext.setAttribute("key","pageContext");
        request.setAttribute("key","request");
        session.setAttribute("key","session");
        application.setAttribute("key","application");
    %>
    pageContext域是否有值：<%=pageContext.getAttribute("key")%><br>
    request域是否有值：<%=request.getAttribute("key")%><br>
    session域是否有值：<%=session.getAttribute("key")%><br>
    application域是否有值：<%=application.getAttribute("key")%><br>

    <%
        request.getRequestDispatcher("/scope2.jsp").forward(request,response);
    %>

</body>
</html>
```

scope2.jsp页面

```jsp
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
```

## jsp中的out输出和response.getWriter输出的区别

response中表示响应，我们经常用于设置返回个客户端的内容（输出）

out也是给用户做输出使用的。

![image-20200814163406493](jsp.assets\image-20200814163406493.png)

由于jsp翻译之后，底层源代码都是使用out来进行输出，所以一般请情况下，我们在jsp页面中统一使用out来进行输出。避免打乱页面输出内容的顺序。

| 方法        | 功能                                                         |
| ----------- | ------------------------------------------------------------ |
| out.write() | 输出字符串都没有问题，整型就会出问题（只适合输出字符串，因为底层方法会将输入全部转成char，所以会出错） |
| out.print() | 输出任意数据都没有问题（都转换成字符串后调用的write输出）    |

深入源码，浅出结论（看）：在jsp页面中，可以统一使用outprint()来进行输出。

## jsp的常用标签

### jsp静态包含

示例说明

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    头部信息<br>
    主体内容<br>
    <%--
        <%@ include file="" %>
        就是静态包含
        file属性指定你要包含的jsp页面路径
        地址中第一个斜杠表示为http://ip:port/工程路径/  映射到代码的web目录
        
        静态包含的特点：
            1. 惊天包含不会翻译被包含的jsp页面
            2. 静态包含其实是把被包含的jsp页面的代码拷贝到包含的位置执行输出。
    --%>

    <%@ include file="/include/footer.jsp" %>
</body>
</html>

```

### jsp动态包含

示例说明：

```jsp
    <%--
        <jsp:include page=""></jsp:include> 这是动态包含
        page属性是指定你要包含的jsp页面路径
        动态包含也可以像惊天包含一样，把被包含的内容指定输出到包含位置

        动态包含特点：
            1. 动态包含会把包含的jsp页面也翻译称为java代码
            2. 动态包含底层代码使用如下去调用被包含的jsp页面执行输出。
            org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/include/footer.jsp", out, false);

    --%>
    <jsp:include page="/include/footer.jsp">
        <jsp:param name="username" value="root"/>
        <jsp:param name="password" value="root"/>
    </jsp:include>


<%--
	下个页面获取数据    
--%>
<body>
    底部内容<br>
    <%=request.getParameter("username")%><br>
    <%=request.getParameter("password")%><br>
</body>
```

动态包含的底层原理：

![image-20200814172312779](jsp.assets\image-20200814172312779.png)

### jsp标签-转发

示例说明

```jsp
    <%--
        <jsp:forward page=""></jsp:forward> 请求转发标签，它的功能就是请求转发
        page属性设置转发路径
    --%>
    <jsp:forward page="footer.jsp"></jsp:forward>
```

## jsp练习

jsp输出一个表格，里边有10个学生信息。

![image-20200814182307758](jsp.assets\image-20200814182307758.png)

Student类：

```java
public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private String phone;
}
```

SearchStudentServlet程序：

```java
public class SearchStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求参数

        // 发sql语句

        // 使用for循环生成查询到的数据做模拟
        List<Student> studentList = new ArrayList<Student>();
        for (int i = 0; i < 10; i++) {
            studentList.add(new Student(i + 1, "name" + i, 18 + i, "phone" + i));
        }

        // 保存查询到的结果（学生信息）到request域中
        req.setAttribute("studentList", studentList);
        // 请求转发到showStudent.jsp页面中
        req.getRequestDispatcher("/test/showStudent.jsp").forward(req, resp);

    }
}
```

showStudent.jsp页面

```jsp
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
```

## 什么是Listener监听器

1. Listerner监听器它是JavaWeb的三大件之一。JavaWeb的三大组件分别是：Servlet程序、Filter过滤器、Listener监听器。
2. Listener它是JavaEE的规范，就是接口。

3. 监听器的作用是，监听某种事物的变化。然后通过回调函数，反馈给回调函数，反馈给客户（程序）去做一些相应的处理。

## ServletContextListener监听器

ServletContextListener他可以监听ServletContext对象的创建和销毁。

ServletContext对象在web工程启动的时候创建，在web工程停止的时候销毁。

监听到创建和销毁之后都会分别调用ServletContextListener监听器的方法反馈。

两个方法分别是：

```java
public interface ServletContextListener extends EventListener {
    /**
     * 在ServletContext对象创建之后马上调用，做初始化
     */
    void contextInitialized(ServletContextEvent var1);

    /**
     * 在ServletContext对象销毁之后调用
     */
    void contextDestroyed(ServletContextEvent var1);
}
```

如何使用ServletContextListener监听器监听ServletContext对象。

使用步骤如下：

1. 编写一个类去实现ServletContextListener
2. 实现其两个调用方法
3. 到web.xml中去配置监听器

监听器实现类：

```java
public class MyServletContextListenerImpl implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext对象被创建了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext对象被销毁了");
    }
}
```

web.xml中的配置

```xml
<listener>
    <listener-class>com.zh.listener.MyServletContextListenerImpl</listener-class>
</listener>
```

# jsp小结

jsp 是 java server pages，java的服务器页面。

作用：	jsp的作用是为了代替Servlet程序回传html页面数据。

jsp的本质是：Servlet程序。

## jsp有三种脚本：

​	
1、声明脚本
​	声明脚本它可以声明jsp页面中的代码。
​	格式是：<%!  %>

2、表达式脚本
	作用： 表达式脚本的作用是在jsp页面上输出数据。
	格式是：<%=  %>

3、代码脚本
	作用：可以在jsp页面中定义自己需要的语句。
	格式是：<%  %>

## jsp中有三种注释：

1、html注释 
		<!--  html注释  -->
		html注释翻译之后会在_jspService()方法以out.write输出到页面

2、java注释 
	// 单行注释
	/*  多行注释 */

java的多行注释在翻译之后在翻译到servlet程序的源代码中

3、jsp注释 
	<%-- jsp注释 --%>
	jsp注释可以注掉jsp中所有内容，在jsp翻译的时候会被完全忽略掉

## jsp中的九大内置对象：

​	1、request		
​	2、response
​	3、pageContext
​	4、exception
​	5、application
​	6、out输出
​	7、page 指向this对象，也就是jsp对象
​	8、session
​	9、servletConfig

## 四个域对象

​	pageContext
​	request
​	session
​	application

它们从小到大的顺序分别是：pageContext 、Request、Session 、application

使用的优先顺序是从小到大：pageContext 、Request、Session 、application

## out和Response输出的区别。

​	out输出都写到out缓冲区中
​	response输出都写到Respnse的缓冲区中，

	当jsp页面中所有代码都执行完成之后。全做以下两个操作
	1、执行out.flush()操作，把out缓冲区中的数据都追加到Response缓冲区中
	2、执行Response的flush()操作。把Response缓冲区中的数据，都写给客户端。
	
	在jsp页面中，统一使用out来进行输出。 
	
	out.write()可以输出字符串
	out.print()可以输出任意数据

## jsp的常用标签

静态包含格式: <%@ include file="">		

动态包含格式是：<jsp:include page="" >

请求转发格式是：<jsp:forward page="" >