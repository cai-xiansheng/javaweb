package com.zh.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-13 9:19
 */
public class RequestApiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        //| getRequestURI()         | 获取请求的资源路径                   |
        System.out.println("URI=> " + req.getRequestURI());
        //| getRequestUEL()         | 获取请求的统一资源定位符（绝对路径） |
        System.out.println("URL=> " + req.getRequestURL());
        //| getRemoteHost()         | 获取客户端的ip地址                   |
        /**
         * localhost访问或127.0.0.1访问，得到的ip地址为127.0.0.1
         */
        System.out.println("客户端ip地址=> " + req.getRemoteHost());
        //| getHeader()             | 获取请求头                           |
        System.out.println("Header=> " + req.getHeader("User-Agent"));
        //| getMethod()             | 获取请求的方式GET或POST              |
        System.out.println("Method=> " + req.getMethod());
    }
}
