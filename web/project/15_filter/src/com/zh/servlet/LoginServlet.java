package com.zh.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-23 0:56
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ("admin".equals(username) && "admin".equals(username)) {
            req.getSession().setAttribute("user", username);
            resp.getWriter().write("登陆成功！！！");
        } else {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
