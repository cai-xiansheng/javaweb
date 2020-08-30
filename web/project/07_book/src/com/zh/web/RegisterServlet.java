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
 * @create 2020-08-13 17:41
 */
public class RegisterServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        String standardCode = "abcde";

        // 2. 检查验证码是否正确 === 写死，要求验证码为：abcde
        if (standardCode.equalsIgnoreCase(code)) {
            // 正确
            // 3. 检查用户名是否可用
            if (userService.existsUsername(username)) {
                // 用户名不可用

                // 把回显信息，保存到request域中
                req.setAttribute("msg","用户名【" + username + "】已存在！");
                req.setAttribute("username", username);
                req.setAttribute("email", email);

                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                // 用户名可用
                // 调用共service保存到数据库
                userService.registerUser(new User(null, username, password, email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            // 不正确
            // 把回显的信息，保存到request域中。
            req.setAttribute("msg", "验证码【" + code + "】错误");
            req.setAttribute("username", username);
            req.setAttribute("email", email);

            // 跳回注册页面
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }


    }
}
