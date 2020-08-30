package com.zh.servlet;

import javax.servlet.RequestDispatcher;
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
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的参数（半是的材料）查看
        String username = req.getParameter("username");
        System.out.println("在Servlet1（柜台1）中查看参数（材料）：" + username);

        // 给材料盖一个章，并传递到Servlet2（柜台2）去查看
        req.setAttribute("key", "柜台1的章");

        // 问路，Servlet2怎么走
        /**
         * 请求转发必须要以/打头，斜杠表示的地址为：http://ip:port/功成名/，映射到idea代码的web目录
         */
        //RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servlet2");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("http://www.baidu.com");

        // 走向Servlet2
        requestDispatcher.forward(req, resp);

    }
}
