package com.zh.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-16 12:19
 */
public abstract class BaseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决post请求中文乱码的问题
        // 一定要在获取请求参数之前那调用才有效
        req.setCharacterEncoding("utf-8");
        // 解决响应中文乱码的问题
        resp.setContentType("text/html; charset=utf-8");
        String action = req.getParameter("action");
        try {
            // 获取action业务鉴别字符串，获取相应的业务方法反射对象
            Method method = this.getClass().getDeclaredMethod(action,
                    HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
