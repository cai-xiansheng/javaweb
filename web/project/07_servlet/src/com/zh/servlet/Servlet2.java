package com.zh.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-13 11:09
 */
public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        System.out.println("在Servlet2（柜台2）中查看参数（材料）：" + username);


        // 查看柜台1是否盖章
        Object key = req.getAttribute("key");
        System.out.println("柜台1是否有章：" + key);

        // 处理自己的业务
        System.out.println("Servlet2处理自己的业务");
    }
}
