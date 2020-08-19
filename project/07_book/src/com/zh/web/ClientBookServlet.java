package com.zh.web;

import com.zh.pojo.Book;
import com.zh.pojo.Page;
import com.zh.service.BookService;
import com.zh.service.impl.BookServiceImpl;
import com.zh.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-19 1:28
 */
public class ClientBookServlet extends BaseServlet{

    private BookService bookService = new BookServiceImpl();

    /**
     * 处理图书请求的分页
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        // 2. 调用BookService。page(pageNo,pageSize):page对象
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("client/bookServlet?action=page");
        // 3. 保存page对象到request域中
        req.setAttribute("page", page);
        // 4. 请求转发到page/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);

    }

    /**
     * 处理图书的价格区间
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);

        // 2. 调用BookService。page(pageNo,pageSize):page对象
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize,min, max);

        StringBuilder stringBuilder = new StringBuilder("client/bookServlet?action=pageByPrice");
        // 如果有罪小价格的参数，就追加到分页条的参数中
        if (req.getParameter("min") != null) {
            stringBuilder.append("&min=").append(req.getParameter("min"));
        }
        // 如果有罪大价格的参数，就追加到分页条的参数中
        if (req.getParameter("max") != null) {
            stringBuilder.append("&max=").append(req.getParameter("max"));
        }

        page.setUrl(stringBuilder.toString());
        // 3. 保存page对象到request域中
        req.setAttribute("page", page);
        // 4. 请求转发到page/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);

    }
}
