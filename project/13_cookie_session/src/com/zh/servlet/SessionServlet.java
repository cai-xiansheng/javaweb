package com.zh.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-20 19:03
 */
public class SessionServlet extends BaseServlet {

    /**
     * Session马上销毁
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取session对象
        HttpSession session = req.getSession();
        // 让session对象马上超时
        session.invalidate();
        resp.getWriter().write("session对象马上超时");
    }

    /**
     * Session3秒超时销毁
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void life3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取session对象
        HttpSession session = req.getSession();
        // 设置当前session在3s后超时
        session.setMaxInactiveInterval(3);
        resp.getWriter().write("当前session已经设置为3s后超时");
    }

    /**
     * Session的默认超时及配置
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取了Session的默认超时时长
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();
        resp.getWriter().write("Session的默认超时时长：" + maxInactiveInterval);
    }

    /**
     * 获取Session域中获取数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object key1 = req.getSession().getAttribute("key1");
        resp.getWriter().write("从Session中获取到的key1的数据是：" + key1);
    }

    /**
     * 向Session域中保存数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1","value1");
        resp.getWriter().write("已经往Session中部署了数据");
    }


    /**
     * 创建或者获取Session对象
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建和获取session会话对象
        HttpSession session = req.getSession();
        // 判断当前Session会话，是否新创建出来的。
        boolean isNew = session.isNew();
        // 获取Session会话的唯一标识id
        String id = session.getId();

        resp.getWriter().write("得到的Session，它的id是：" + id + "<br/>");
        resp.getWriter().write("这个Session是否是新创建的：" + isNew + "<br/>");
    }

}
