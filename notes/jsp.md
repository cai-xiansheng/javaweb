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

![image-20200813231629779](C:\Users\张辉\Desktop\javaweb\notes\jsp.assets\image-20200813231629779.png)

我们跟踪源代码发现，HttpJspBase类。他直接继承了HttpServlet类，也就是说，jsp翻译出来的java类，它间接的继承了HttpServlet类。也就是说，翻译出来的是一个Servlet程序。

![image-20200813231838654](C:\Users\张辉\Desktop\javaweb\notes\jsp.assets\image-20200813231838654.png)

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

