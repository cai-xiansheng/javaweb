package com.zh.servlet;

import com.zh.util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-20 15:07
 */
public class CookieServlet extends BaseServlet {

    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("path1", "path1");
        // getContextPath()得到工程路径
        cookie.setPath(req.getContextPath() + "/abc"); // /工程路径/abc
        resp.addCookie(cookie);
        resp.getWriter().write("创建了一个带有path路径的Cookie");
    }


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

    /**
     * Cookie的值的修改
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ////1. 先创建一个要修改的同名的Cookie对象
        ////2. 在构造器，同时赋予新的Cookie值。
        //Cookie cookie = new Cookie("key1","newCookie");
        ////3. 在调用response.addCookie(Cookie);通知客户端保存修改
        //resp.addCookie(cookie);
        //resp.getWriter().write("key1的Cookie修改好了");

        //1. 先查找需要修改的Cookie对象
        Cookie cookie = CookieUtils.finCookie("key2", req.getCookies());
        //2. 调用setValue()方法赋予新的Cookie值。
        cookie.setValue("newValue2");
        //3. 调用response.addCookie()通知客户端保存修改。
        resp.addCookie(cookie);
    }


    /**
     * 服务器端获取Cookie
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
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

    /**
     * 创建Cookie
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
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

}
