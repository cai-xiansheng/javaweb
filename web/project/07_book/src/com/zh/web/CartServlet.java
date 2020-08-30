package com.zh.web;

import com.google.gson.Gson;
import com.zh.pojo.Book;
import com.zh.pojo.Cart;
import com.zh.pojo.CartItem;
import com.zh.service.BookService;
import com.zh.service.impl.BookServiceImpl;
import com.zh.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-22 0:17
 */
public class CartServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的商品参数，商品编号，商品数量
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        int count = WebUtils.parseInt(req.getParameter("count"), 0);
        // 获取Cart对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.updateCount(id, count);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 清空购物车
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            // 删除商品对象
            cart.clear();
            // 重定向回原来购物车页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 删除商品项
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取商品编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        // 获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            // 删除商品对象
            cart.deleteItem(id);
            // 重定向回原来购物车页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 加入购物车
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("加入购物车");
        //System.out.println("商品编号：" + req.getParameter("id"));

        // 获取请求的参数商品的编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        // 调用bookService.queryBookId(id):Book得到图书的信息
        Book book = bookService.queryBookById(id);
        // 把图书细腻些，转化成为CartItem商品项。
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        // 调用Cart.add(CartItem);添加商品项
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            // 此时说明没有cart
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);
        System.out.println(cart);
        // 重定向会商品列表
        resp.sendRedirect(req.getHeader("Referer"));
        req.getSession().setAttribute("lastName", cartItem.getName());
    }


    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("加入购物车");
        //System.out.println("商品编号：" + req.getParameter("id"));

        // 获取请求的参数商品的编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        // 调用bookService.queryBookId(id):Book得到图书的信息
        Book book = bookService.queryBookById(id);
        // 把图书细腻些，转化成为CartItem商品项。
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        // 调用Cart.add(CartItem);添加商品项
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            // 此时说明没有cart
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);
        System.out.println(cart);
        //// 重定向会商品列表
        //resp.sendRedirect(req.getHeader("Referer"));
        //req.getSession().setAttribute("lastName", cartItem.getName());

        // 6. 返回购物车总的商品数量和最后一个添加的商品名称
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("totalCount", cart.getTotalCount());
        resultMap.put("lastName", cartItem.getName());

        Gson gson = new Gson();
        String resultMapJsonString = gson.toJson(resultMap);
        resp.getWriter().write(resultMapJsonString);
    }

}
