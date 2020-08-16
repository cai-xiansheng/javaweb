package com.zh.web;

import com.zh.pojo.User;
import com.zh.service.UserService;
import com.zh.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-13 18:46
 */
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User loginUser = userService.login(new User(null, username, password, null));
        if (loginUser == null) {
            // 登录失败
            // 把错误信息，和回显的表单项信息，保存到request域种。
            req.setAttribute("msg","账号或密码错误！");
            req.setAttribute("username", username);

            // 跳回登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        } else {
            // 登录成功
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }
}
