package com.zh.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-23 1:32
 */
public class Filter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter1前置代码");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("Filter1后置代码");
    }

    @Override
    public void destroy() {

    }
}
