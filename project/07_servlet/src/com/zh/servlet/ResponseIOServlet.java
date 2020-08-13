package com.zh.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-13 12:15
 */
public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println(resp.getCharacterEncoding());

        // 设置服务器字符集为utf-8
        //resp.setCharacterEncoding("utf-8");
        // 通过响应头，设置浏览器也使用utf-8字符集
        //resp.setHeader("Content-type","text/html; charset=utf-8");


        // 他会同时设置服务器和客户端都使用utf-8字符集，还设置了响应头
        // 此方法一定要在获取流对象之前调用才有效
        resp.setContentType("text/html; charset=utf-8");


        PrintWriter writer = resp.getWriter();
        writer.write("response's content!这是汉字");

    }
}
