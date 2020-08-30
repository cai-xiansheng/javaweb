package com.zh.filter;

import com.zh.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-24 12:35
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest, servletResponse);

            JdbcUtils.commitAndClose(); // 事务提交
        } catch (Exception e) {
            JdbcUtils.rollbackAndClose(); // 事务回滚
            throw new RuntimeException(e); // 把异常抛给Tomcat管理展示友好的错误的页面
        }
    }

    @Override
    public void destroy() {

    }
}
