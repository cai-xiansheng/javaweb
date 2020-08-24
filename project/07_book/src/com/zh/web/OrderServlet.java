package com.zh.web;

import com.zh.pojo.Cart;
import com.zh.pojo.User;
import com.zh.service.OrderService;
import com.zh.service.impl.OrderServiceImpl;
import com.zh.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-22 15:57
 */
public class OrderServlet extends BaseServlet {

    private OrderService orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 先获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        // 获取userId
        User loginUser = (User) req.getSession().getAttribute("user");
        if (loginUser == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            return;
        }
        Integer userId = loginUser.getId();
        // 调用OrderService.createOrder(cart,userId)
        String orderId = orderService.createOrder(cart, userId);

        //req.setAttribute("orderId", orderId);
        // 请求转发到/pages/cart/checkout.jsp
        //req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req, resp);


        req.getSession().setAttribute("orderId", orderId);
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }

}
