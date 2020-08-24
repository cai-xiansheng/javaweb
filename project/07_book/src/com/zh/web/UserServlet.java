package com.zh.web;

import com.google.gson.Gson;
import com.zh.pojo.User;
import com.zh.service.UserService;
import com.zh.service.impl.UserServiceImpl;
import com.zh.utils.WebUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-16 11:35
 */
public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取请求的参数
        String username = req.getParameter("username");
        // 2. 调用userService.existsUsername(username);
        Boolean existsUsername = userService.existsUsername(username);
        // 3. 把返回的结果，封装为map对象
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("existsUsername", existsUsername);
        Gson gson = new Gson();

        String json = gson.toJson(resultMap);
        resp.getWriter().write(json);


    }

    /**
     * 处理登录
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User loginUser = userService.login(new User(null, username, password, null));
        if (loginUser == null) {
            // 登录失败
            // 把错误信息，和回显的表单项信息，保存到request域种。
            req.setAttribute("msg", "账号或密码错误！");
            req.setAttribute("username", username);
            // 跳回登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            // 登录成功
            req.getSession().setAttribute("user", loginUser);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }

    /**
     * 注销处理
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 销毁Session中用户登录的信息（或者销毁Session）
        HttpSession session = req.getSession();
        session.invalidate();
        // 2. 重定向到首页（或者登录页面）
        resp.sendRedirect(req.getContextPath());
    }

    /**
     * 处理注册
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取session中的验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        // 删除Session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");


        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());


        // 2. 检查验证码是否正确 === 写死，要求验证码为：abcde
        if (token != null && token.equalsIgnoreCase(code)) {
            // 正确
            // 3. 检查用户名是否可用
            if (userService.existsUsername(username)) {
                // 用户名不可用

                // 把回显信息，保存到request域中
                req.setAttribute("msg", "用户名【" + username + "】已存在！");
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
