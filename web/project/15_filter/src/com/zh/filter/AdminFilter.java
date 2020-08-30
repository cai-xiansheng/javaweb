package com.zh.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-23 0:34
 */
public class AdminFilter implements Filter {

    public AdminFilter() {
        System.out.println("1. AdminFilter.AdminFilter");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("2. AdminFilter.init");
        //+ 获取Filter的名称**filter-name**的内容
        System.out.println("filter-name的值是：" + filterConfig.getFilterName());
        //+ 获取在web.xml中配置的**init-param**初始化参数
        System.out.println("初始化参数username是：" + filterConfig.getInitParameter("username"));
        System.out.println("初始化参数url是：" + filterConfig.getInitParameter("url"));
        //+ 获取ServletContext对象
        System.out.println("ServletContext对象：" + filterConfig.getServletContext());
    }

    /**
     * doFilter方法，专门用来拦截请求。可以做权限检查
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("3. AdminFilter.doFilter");


        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();
        Object user = session.getAttribute("user");

        if (user == null) {
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
            return;
        } else {
            // 让程序继续往下访问用户的目标资源
            filterChain.doFilter(servletRequest, servletResponse);
        }


    }

    @Override
    public void destroy() {
        System.out.println("4. AdminFilter.destroy");
    }
}
