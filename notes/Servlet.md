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

