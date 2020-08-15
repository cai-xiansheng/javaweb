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

        // 2. 检查验证码是否正确 === 写死，要求验证码为：abcde
        if ("abcde".equalsIgnoreCase(code)) {
            // 正确
            // 3. 检查用户名是否可用
            if (userService.existsUsername(username)) {
                // 用户名不可用
                System.out.println("用户名【" + username + "】已存在！");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                // 用户名可用
                // 调用共service保存到数据库
                userService.registerUser(new User(null, username, password, email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            // 不正确
            // 跳回注册页面
            System.out.println("验证码【" + code + "】错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }


    }
}
