# Cookie

> 饼干

## 什么是Cookie

1. Cookie翻译过来是饼干的意思。
2. Cookie是服务器通知客户端保存键值对的一种技术。
3. 客户端有了Cookie后，每次请求都发送给服务器。
4. 每个Cookie的大小不能超过4kb.

## 如何创建Cookie

![image-20200820145838620](Cookie&&Session.assets\image-20200820145838620.png)

Servlet程序中的代码

```java
    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 创建Cookie对象
        Cookie cookie1 = new Cookie("key1", "value1");
        // 2. 通知客户端保存Cookie
        resp.addCookie(cookie1);
        // 1. 创建Cookie对象
        Cookie cookie2 = new Cookie("key2", "value2");
        // 2. 通知客户端保存Cookie
        resp.addCookie(cookie2);

        resp.getWriter().write("Cookie创建成功！");
    }
```

## 服务器如何获取Cookie

服务器获取客户端的Cookie只需要一行代码：`req.getCookies():Cookir[]`

![image-20200820152817618](Cookie&&Session.assets/image-20200820152817618.png)

CookiesUtil工具类

```java
public class CookieUtils {

    /**
     * 查找指定名称的Cookie对象
     * @param name
     * @param cookies
     * @return
     */
    public static Cookie finCookie(String name,Cookie[] cookies) {
        if (name == null || cookies == null || cookies.length == 0) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie;
            }
        }
        return null;
    }

}
```

Servlet程序中的代码

```java
    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();


        for (Cookie cookie : cookies) {
            // getName方法，返回Cookie的key(名)
            // getValue方法，返回Cookie的value(值)
            resp.getWriter().write("Cookie【" + cookie.getName() + "=" + cookie.getValue() + "】<br/>");
        }

        Cookie iWantCookie = CookieUtils.finCookie("key1",cookies);

        // 如果不等于null，说明赋过值，也就是找到了需要的Cookie
        if (iWantCookie != null) {
            resp.getWriter().write("找到了需要的Cookie");
        }
    }
```

## Cookie值的修改

### 方案一：

1. 先创建一个要修改的同名的Cookie对象
2. 在构造器，同时赋予新的Cookie值。
3. 在调用response.addCookie(Cookie);

```java
//1. 先创建一个要修改的同名的Cookie对象
//2. 在构造器，同时赋予新的Cookie值。
Cookie cookie = new Cookie("key1","newCookie");
//3. 在调用response.addCookie(Cookie);通知客户端保存修改
resp.addCookie(cookie);
resp.getWriter().write("key1的Cookie修改好了");
```

### 方案二：

1. 先查找需要修改的Cookie对象
2. 调用setValue()方法赋予新的Cookie值。
3. 调用response.addCookie()通知客户端保存修改。

```java
//1. 先查找需要修改的Cookie对象
Cookie cookie = CookieUtils.finCookie("key2", req.getCookies());
//2. 调用setValue()方法赋予新的Cookie值。
cookie.setValue("newValue2");
//3. 调用response.addCookie()通知客户端保存修改。
resp.addCookie(cookie);
```

## Cookie生命控制

> Cookie的声明控制值得是如何管理Cookie什么时候被销毁（删除）

**setMaxAge()**

正数：表示在指定的秒数后过期

负数：表示浏览器一关，Cookie就会被删除（默认值是-1）

零：表示马上删除Cookie

```java
/**
 * Cookie 3600s 后删除
 * @param req
 * @param resp
 * @throws ServletException
 * @throws IOException
 */
protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Cookie cookie = CookieUtils.finCookie("key2", req.getCookies());
    cookie.setMaxAge(60 * 60); // 表示马上删除
    resp.addCookie(cookie);
    resp.getWriter().write("key2的Cookie在3600s后被删除");
}

/**
 * Cookie立即删除
 * @param req
 * @param resp
 * @throws ServletException
 * @throws IOException
 */
protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Cookie cookie = CookieUtils.finCookie("key1", req.getCookies());
    cookie.setMaxAge(0); // 表示马上删除
    resp.addCookie(cookie);
    resp.getWriter().write("key1的Cookie被删除");
}

/**
 * Cookie的默认存活时间
 * @param req
 * @param resp
 * @throws ServletException
 * @throws IOException
 */
protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Cookie cookie = new Cookie("defaultLife", "defaultLife");
    cookie.setMaxAge(-1); // 设置存活时间
    resp.addCookie(cookie);
}
```

## Cookie有效路径Path的设置

Cookie的Path属性可以有效的过滤哪些Cookie可以发送给服务器，哪些不发。

path属性是通过请求的地址来进行有效过滤。

| CookieA | path=/工程路径     |
| ------- | ------------------ |
| CookieB | path=/工程路径/abc |

请求地址如下：

http://ip:port/工程路径/a.html

+ CookieA发送
+ CookieB不发送

http://ip:port/工程路径/abc/a.html

+ CookieA发送
+ CookieB发送

## Cookie练习

![image-20200820170226344](Cookie&&Session.assets/image-20200820170226344.png)

# Session会话

## 什么是Session会话？

1. Session就是一个接口（HttpSession）。
2. Session就是会话。它是用来维护一个客户端和服务器之间关联的一种技术。
3. 每个客户端都有自己的一个Session会话。
4. Session会话中，我们经常用来保存用户登录之后的信息。

## 如何创建Session和获取（id号，是否为新）

1. 如何创建和获取Session。他们的API是一样的。
2. request.getSession()
   + 第一次调用是:创建Session会话
   + 之后调用都是:获取前面创建好的Session会话对象.
3. isNew():判断到底是不是刚创建出来的(新的)
   + true:表示刚创建
   + false:表示获取之后创建

4. 每个会话都有一个身份证号,也就是ID值．而且这个ID是唯一的。
5. getId()得到session的绘画id值。

## Session域的数据的存取

```java
/**
 * 获取Session域中获取数据
 * @param req
 * @param resp
 * @throws ServletException
 * @throws IOException
 */
protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Object key1 = req.getSession().getAttribute("key1");
    resp.getWriter().write("从Session中获取到的key1的数据是：" + key1);
}

/**
 * 向Session域中保存数据
 * @param req
 * @param resp
 * @throws ServletException
 * @throws IOException
 */
protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getSession().setAttribute("key1","value1");
    resp.getWriter().write("已经往Session中部署了数据");
}
```

## Session生命周期控制

1. public void setMaxInactiveInterval(int interval) 设置Session的超时时间（以秒为单位），超过指定时长，session就会被销毁。
2. 值为正数的时候，设定Session的超时时长。
3. 值为负数的时候，表示永不超时（极少使用）

4. public int getMaxInactiveInterval() 获取Session的超时时间。
5. public void invalidate() 让当前Session绘画马上超时无效。



Session默认的超时时长为30分钟。

因为在Tomcat服务器的配置文件web.xml中默认有以下的配置，他就表示配置了当前Tomcat服务器下所有的Session超时配置默认时长为：30分钟。

<session-config>

​	<session-timeout>30</session-timeout>

</session-config>

如果说，你希望你的web工程，默认的Session的超时时长为其他时长。你可以在自己的web.xml配置文件中做以上相同的配置，就可以修改你的web工程所有的Session的默认超时时长。

如果你想只修改个别Session的超时时长，就可以使员工上面的API。setMaxInactiveInterval(int interval)来进行单独的设置

session.setMaxInactiveInterval(int interval)单独设置超时时长

Session超时的概念介绍。

![image-20200820193832603](Cookie&&Session.assets/image-20200820193832603.png)

## 浏览器和Session之间的关联

Session技术，底层是基于Cookie实现的。

![image-20200820201203845](Cookie&&Session.assets/image-20200820201203845.png)