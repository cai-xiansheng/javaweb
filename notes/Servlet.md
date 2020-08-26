# Servlet技术

## 什么是Servlet

1. Servlet是JavaEE规范之一，规范就是接口。
2. Servlet是JavaWeb三大件之一，三大组件分别是Servlet程序、Filter过滤器、Listener监听器。
3. Servlet是运行在服务器上的一个java小程序，它可以接收客户端发送过来的请求，并响应数据给客户端

## 手动实现Servlet程序

1. 编写一个类去实现Servlet接口
2. 事先service方法，处理请求，并响应数据。
3. 到web.xml中配置servlet程序的访问地址。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">


    <!--servlet标签给Tomcat配置Servlet程序-->
    <servlet>
        <!--servlet-name标签Servlet程序起了一个别名-->
        <servlet-name>HelloServlet</servlet-name>
        <servlet-class>com.zh.servlet.HelloServlet</servlet-class>
    </servlet>

    <!--servlet-mapping标签给servlet程序配置访问地址-->
    <servlet-mapping>
        <!--servlet-name标签的作用是告诉服务器，我当前配置的地址给那个Servlet程序使用-->
        <servlet-name>HelloServlet</servlet-name>
        <!--url-pattern标签配置访问地址
            /   斜杠在服务器解析的时候，表示地址为http://ip:port/工程路径  <br/>
            /hello  表示地址为：http://ip:port/工程路径/hello  <br/>
        -->
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>

</web-app>
```

### 常见错误：

1. url-pattern中配置的路径没有以斜杠打头
2. servlet-name配置的值不存在
3. servlet-class标签的全类名配置错误

## url地址到Servlet的访问

![image-20200812152602804](Servlet.assets\image-20200812152602804.png)

## Servlet的生命周期

1. 执行Servlet构造器方法
2. 执行init初始化方法
3. 执行service方法
4. 执行desteoy销毁方法

+ 第一、二步是在第一次访问的时候创建Servlet程序会调用
+ 第三步，每次访问的时候都会调用。
+ 第四步，在web工程停止的时候调用。

## GET和POST请求的分发

```java
	 /**
     * service方法是专门用来请求和响应的
     *
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3 service方法 Hello Servlet被访问了！");

        // 类型转换（因为它有getMethod()方法）
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        // 获取请求的方式
        String method = httpServletRequest.getMethod();
        String get = "GET";
        String post = "POST";
        if (get.equals(method)) {
            doGet();
        } else if (post.equals(method)) {
            doPost();
        }
    }

    /**
     * 做get请求的操作
     */
    public void doGet() {
        System.out.println("get");
    }

    /**
     * 做post请求的操作
     */
    public void doPost() {
        System.out.println("post");
    }
```

## 通过继承HttpServlet实现Servlet程序

一般在实际项目开发中，都是使用继承HttpServlet类的方式去实现Servlet程序。

1. 编写一个类去继承HttpServlet类
2. 根据业务需要重写doGet或doPost方法
3. 到web.xml中配置Servlet程序的访问地址

servlet类

```java
public class HelloServlet2 extends HttpServlet {

    /**
     * doGet() 在get请求的时候调用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        System.out.println("Get");
    }

    /**
     * doPost() 在post请求的时候调用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        System.out.println("Post");
    }
}
```

web.xml配置

```xml
    <servlet>
        <servlet-name>HelloServlet2</servlet-name>
        <servlet-class>com.zh.servlet.HelloServlet2</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>HelloServlet2</servlet-name>
        <url-pattern>/hello2</url-pattern>
    </servlet-mapping>
```

## 使用idea创建servlet程序

![image-20200812185139532](Servlet.assets\image-20200812185139532.png)

配置Servlet的信息：

![image-20200812185337447](Servlet.assets\image-20200812185337447.png)

## Servlet的继承体系

![image-20200812185414478](Servlet.assets\image-20200812185414478.png)

# ServletConfig类

ServletConfig类从类名上来看，就知道是Servlet程序的配置信息类。

Servlet程序和ServletConfig对象都是由Tomcat负责创建，我们负责使用。

Servlet程序默认是第一次访问的时候创建，ServletConfig是每个Servlet程序创建时，就创建一个对应的ServletConfig对象。

## ServletConfig类的三大作用

1. 可以获得Servlet程序的别名servlet-name的值
2. 获取初始化参数init-param
3. 获取ServletContext对象

web.xml中的配置

```xml
	<!--servlet标签给Tomcat配置Servlet程序-->
    <servlet>
        <!--servlet-name标签Servlet程序起了一个别名-->
        <servlet-name>HelloServlet</servlet-name>
        <servlet-class>com.zh.servlet.HelloServlet</servlet-class>

        <!--init-param是初始化参数-->
        <init-param>
            <!--参数名-->
            <param-name>username</param-name>
            <!--参数值-->
            <param-value>root</param-value>
        </init-param>
        <!--init-param是初始化参数-->
        <init-param>
            <!--参数名-->
            <param-name>url</param-name>
            <!--参数值-->
            <param-value>jdbc:mysql://localhost:3306/test</param-value>
        </init-param>
    </servlet>

    <!--servlet-mapping标签给servlet程序配置访问地址-->
    <servlet-mapping>
        <!--servlet-name标签的作用是告诉服务器，我当前配置的地址给那个Servlet程序使用-->
        <servlet-name>HelloServlet</servlet-name>
        <!--url-pattern标签配置访问地址
            /   斜杠在服务器解析的时候，表示地址为http://ip:port/工程路径  <br/>
            /hello  表示地址为：http://ip:port/工程路径/hello  <br/>
        -->
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>
```

Servlet中的代码：

```java
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2 init初始化方法");

        //1. 可以获得Servlet程序的别名servlet-name的值
        System.out.println("HelloServlet程序的别名是：" + servletConfig.getServletName());
        //2. 获取初始化参数init-param
        System.out.println("初始化参数username的值是：" + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是：" + servletConfig.getInitParameter("url"));
        //3. 获取ServletContext对象
        System.out.println(servletConfig.getServletContext());

    }
```

注意点：

![image-20200812192545246](Servlet.assets\image-20200812192545246.png)

# ServletContext类

## 什么是ServletContext

1. ServletContext是一个接口，它表示Servlet上下文对象
2. 一个web工程，只有一个ServletContext对象实例
3. ServletContext对象是**一个**域对象。
4. ServletContext是在web工程部署启动的时候创建的，在web工程停止的时候销毁。



什么是域对象？

域对象，是可以像Map一样存取数据的对象，叫域对象。

这里的域指的是存取数据的操作范围，整个web工程。

|        | 存数据         | 取数据         | 删除数据          |
| ------ | -------------- | -------------- | ----------------- |
| Map    | put()          | get()          | remove()          |
| 域对象 | setAttribute() | getAttribute() | removeAttribute() |

## ServletContext类的四个作用

1. 获取web.xml中配置的上下文参数context-param

2. 获取当前的工程路径，格式：/工程路径

3. 获取工程部署后在服务器硬盘上的绝对路径

4. 像Map一样存取数据

   1,2,3

```java
        //1. 获取web.xml中配置的上下文参数context-param
        ServletContext servletContext = getServletConfig().getServletContext();
        System.out.println("context-param参数username的值是：" + servletContext.getInitParameter("username"));
        System.out.println("context-param参数password的值是：" + servletContext.getInitParameter("password"));


        //2. 获取当前的工程路径，格式：/工程路径
        System.out.println("当前工程路径：" + servletContext.getContextPath());
        //3. 获取工程部署后在服务器硬盘上的绝对路径

        // / 斜杠被服务器解析地址为http://ip:port/工程名/    映射到IDEA代码的web目录<br/>
        System.out.println("工程部署路径是：" + servletContext.getRealPath("/"));

        System.out.println("工程下css目录的绝对路径是：" + servletContext.getRealPath("/css"));
```

# Http协议

## 什么是Http协议

### 什么是协议

协议是指双方，或多方，相互约定好，大家都需要遵守的规则，叫协议。



所谓的Http协议，就是指，客户端和服务器之间通信时，发送的数据，需要遵守的规则，叫Http协议。

Http协议中的数据又叫报文。

## 请求的Http协议格式

客户端给服务器发送数据叫请求。

服务器给客户端回传数据叫响应。

请求又分为GET请求，和POST请求两种。

### GET请求

1. 请求行
   1. 请求的方式	GET
   2. 请求的资源路径[ + ? + 请求的参数]
   3. 请求的协议的版本号      HTTP/1.1
2. 请求头
   1. key:value 组成 键值对	不同键值对，表示不同的含义

![image-20200813081913623](Servlet.assets\image-20200813081913623.png)

### POST请求

1. 请求行
   1. 请求的方式	GET
   2. 请求的资源路径[ + ? + 请求的参数]
   3. 请求的协议的版本号      HTTP/1.1

2. 请求头

   1. key:value		不同的请求头，又不同的含义

   `空行`

3. 请求体    ===》   就是发送给服务器的数据

![image-20200813083038025](Servlet.assets\image-20200813083038025.png)

### 常用请求头的说明

| Accept          | 表示客户端可以接受的数据类型 |
| --------------- | ---------------------------- |
| Accept-Language | 表示客户端可以接受的语言类型 |
| User-Agent      | 表示客户端浏览器的信息       |
| Host            | 表示请求时的IP和端口号       |

### 哪些是GET请求，哪些是POST请求

GET请求有哪些：

1. form标签method=get
2. a标签
3. link标签引入css
4. script标签引入js文件
5. img标签引入图片
6. iframe引入html页面
7. 在浏览器中地址栏中输入地址后敲回车

POST请求有哪些：

1. form标签method = post

## 响应的HTTP协议格式

1. 响应行
   1. 响应协议和版本号
   2. 响应状态码           
   3. 响应状态描述符           
2. 响应头
   1. key:value    不同的响应头，有其不同的含义
3. 响应体 ---》 就是回传给客户端的数据

![image-20200813084730514](Servlet.assets\image-20200813084730514.png)

## 常用的响应码说明

| 状态码 | 含义                                                         |
| ------ | ------------------------------------------------------------ |
| 200    | 表示请求成功                                                 |
| 302    | 表示请求重定向                                               |
| 404    | 表示请求服务器已经收到，但是你要的数据不存在（请求地址错误） |
| 500    | 表示服务器已经收到请求，但是服务器内部错误（代码错误）       |

## MIME类型说明

MIME是HTTP协议中数据类型。

MIME是英文全称是“Multipurpose Internet Mail Extensions”多功能Internet邮件扩充服务。MIME类型的格式是“大类型/小类型”，并于某一种文件的扩展名相对应。

常见的MIME类型：

| 文件               | 我们看到的后缀 | MIME类型                 |
| ------------------ | -------------- | ------------------------ |
| 超文本标记语言文本 | .html, .htm    | text/html                |
| 普通文本           | .txt           | text/plain               |
| RTF文本            | .rtf           | application/rtf          |
| GIF图形            | .gif           | image/gif                |
| JPEG图形           | .jepg, .jpg    | image/jepg               |
| au声音文件         | .au            | audio/basic              |
| MIDI音乐文件       | .mid, midi     | audio/midi, audio/x-midi |
| RealAudio音乐文件  | .ra, .ram      | audio/x-pn-realaudio     |
| MPEG文件           | .mpg, .mpeg    | video/mpeg               |
| AVI文件            | .avi           | video/x-msvideo          |
| GZIP文件           | .gz            | application/x-gzip       |
| TAR文件            | .tar           | application/x-tar        |

# HttpServletRequest类

## HttpServletRequest类有什么作用

每次只要有请求进入Tomcat服务器，Tomcat服务器就会把我们请求过来的HTTP协议信息解析好封装到Request对象中。然后传递到service方法（doGet和doPost）中给我们使用。我们可以通过HttpServletRequest对象，获取到所有请求的信息。

## HttpServletRequest类常用的方法

| 方法                    | 作用                                 |
| ----------------------- | ------------------------------------ |
| getRequestURI()         | 获取请求的资源路径                   |
| getRequestUEL()         | 获取请求的统一资源定位符（绝对路径） |
| getRemoteHost()         | 获取客户端的ip地址                   |
| getHeader()             | 获取请求头                           |
| getParameter()          | 获取请求的参数                       |
| getParameterValues()    | 获取请求的参数（多个值的时候使用）   |
| getMethod()             | 获取请求的方式GET或POST              |
| setAttribute(key,value) | 设置域数据                           |
| getRequestDispatcher()  | 获取请求转发对象                     |

## 如何获取请求参数

```java
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        System.out.println("---------doGet--------");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobby = req.getParameterValues("hobby");
        System.out.println("用户名：" + username);
        System.out.println("密码：" + password);
        System.out.println("爱好：" + Arrays.asList(hobby));
    }
```

## 解决中文乱码的问题

```java
// 设置请求体的字符机为utf-8，从而解决post请求的中文乱码问题
req.setCharacterEncoding("utf-8");
System.out.println("---------doPost--------");
```

## 请求转发

### 什么是请求转发

请求转发是指，服务器收到请求后，从一次资源跳转到另一个资源的操作叫做请求转发。

![image-20200813110915211](Servlet.assets\image-20200813110915211.png)

请求转发只能在WEB下转发。

## base标签解决请求转发时参照路径

![image-20200813114924478](Servlet.assets\image-20200813114924478.png)

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!--
        base标签设置页面工作时的相对路径工作时参照的地址
        href    属性就是参数的地址值
        最后的资源名可以省略，但是最后的斜杠不能省略。
    -->
    <base href="http://localhost:8080/07_servlet/a/b/c.html">
</head>
<body>
    <a href="../../">index.html</a>
</body>
</html>
```

## Web中的相对路径和绝对路径

在JavaWeb中，路径分为相对路径和绝对路径两种：

相对路径：

+ `.		表示当前目录`
+ `..        表示上一级目录`
+ 资源名       表示当前目录/资源名

绝对路径：

http://ip:port/工程路径/资源路径

在实际开发中，路径都是用绝对路径，而不简单的使用相对路径。

1. 绝对路径
2. base相对

## web中/斜杠的不同意义

在web中，/斜杠是一种绝对路径

/斜杠如果被浏览器解析，得到的路径是：http://ip:port/

`<a href="/">斜杠</a>`

/斜杠如果被服务器解析，得到的地址是：http://ip:port/工程路径

1. ==<url-pattern>/servlet1</url-pattern>==
2. servletContext.getRealPath("/");
3. request.getRequestDirspatcher("/");

特殊情况：response.sendRediect("/");    把斜杠发送给浏览器解析。得到http://ip:port/

# HttpServletResponse类

## HttpServletResponse类的作用

HttpServletResponse类和HttpServletRequest类一样，每次请求进来，Tomcat服务器都会创建一个Response对象传递给Servlet程序去使用。HttpServletRequest表示请求过来的信息，HttpServletResponse表示所有响应的信息。

我们如果需要设置返回给客户端的信息，都可以通过HttpServletResponse对象来进行设置。

## 两个流的说明

| 流     | 方法              | 作用                         |
| ------ | ----------------- | ---------------------------- |
| 字节流 | getOutputStream() | 常用于下载（传递二进制数据） |
| 字符流 | getWriter()       | 常用于回传字符串（常用）     |

两个流同时只能使用一个。

使用了字节流，就不能使用字符流，反之亦然，否则就会报错。

![image-20200813121908596](Servlet.assets\image-20200813121908596.png)

同时使用了两个响应流，就报错。

## 如何往客户端回传数据

要求：往客户端回传字符串数据。

```java
public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.write("response's content!这是汉字");

    }
}
```

## 响应的乱码解决

解决响应乱码的方案1（不推荐）

```java
// 设置服务器字符集为utf-8
resp.setCharacterEncoding("utf-8");
// 通过响应头，设置浏览器也使用utf-8字符集
resp.setHeader("Content-type","text/html; charset=utf-8");
```

解决响应乱码的方案1（推荐）

```java
// 他会同时设置服务器和客户端都使用utf-8字符集，还设置了响应头
// 此方法一定要在获取流对象之前调用才有效
resp.setContentType("text/html; charset=utf-8");

```

## 请求重定向

请求重定向是指客户端给服务器发请求，然后服务器告诉客户端说。我给你一下地址，你去新地址访问。叫请求重定向（因为之前的地址可能已经被废弃）

![image-20200813124726301](Servlet.assets\image-20200813124726301.png)

请求重定向的第一种方案：

```java
// 设置响应状态码302，表示重定向（已搬迁）
resp.setStatus(302);
// 设置响应头，说明新的地址在哪儿
resp.setHeader("Location","http://localhost:8080/07_servlet/response2");
```

请求重定向的第二种方案（推荐使用）：

```java
resp.sendRedirect("http://localhost:8080/07_servlet/response2");
```

