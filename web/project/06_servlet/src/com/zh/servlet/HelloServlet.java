package com.zh.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-12 14:50
 */
public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println("1 构造器方法");
    }

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

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

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

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4 销毁方法");
    }
}
