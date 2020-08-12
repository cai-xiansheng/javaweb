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

![image-20200812152602804](C:\Users\张辉\Desktop\javaweb\notes\Servlet.assets\image-20200812152602804.png)

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

![image-20200812185139532](C:\Users\张辉\Desktop\javaweb\notes\Servlet.assets\image-20200812185139532.png)

配置Servlet的信息：

![image-20200812185337447](C:\Users\张辉\Desktop\javaweb\notes\Servlet.assets\image-20200812185337447.png)

## Servlet的继承体系

![image-20200812185414478](C:\Users\张辉\Desktop\javaweb\notes\Servlet.assets\image-20200812185414478.png)

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

![image-20200812192545246](C:\Users\张辉\Desktop\javaweb\notes\Servlet.assets\image-20200812192545246.png)

# ServletContext类

## 什么是ServletContext

1. ServletContext是一个接口，它表示Servlet上下文对象
2. 一个web工程，只有一个ServletContext对象实例
3. ServletContext对象是一个域对象。
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