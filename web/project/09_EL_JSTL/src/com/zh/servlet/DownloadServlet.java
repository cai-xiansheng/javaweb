package com.zh.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-15 16:14
 */
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取要下载的文件名
        String downloadFileName = "2.jpg";
        String downloadFilePath = "/file/" + downloadFileName;
        // 2. 读取要下载的文件内容(通过ServletContext对象就可以读取)
        ServletContext servletContext = getServletContext();

        // 获取要下载的文件类型
        String mimeType = servletContext.getMimeType(downloadFilePath);
        System.out.println("下载的文件类型：" + mimeType);
        // 4. 在回传前，通过响应头告诉客户端返回的数据类型
        resp.setContentType(mimeType);

        // 5. 还要告诉客户端收到的数据是用于下载的（还是使用响应头）
        // Content-Disposition响应头，表示收到的数据怎么处理
        // attachment表示附件，表示下载时使用
        // filename= 表示指定下载的文件名
        if (req.getHeader("User-Agent").contains("Firefox")) {
            // 如果是火狐浏览器，使用Base64编码
            resp.setHeader("Content-Disposition", "attachment; fileName==?UTF-8?B?" + Base64.getEncoder().encode("张三以.jpg".getBytes()) + "?=" );
        } else {
            // 如果不是火狐，使用URL编码操作
            resp.setHeader("Content-Disposition", "attachment; fileName=" + URLEncoder.encode("张三.jpg", StandardCharsets.UTF_8));
        }

        /**
         * /斜杠被服务器解析表示地址为http://ip:port/工程名/ 映射到代码的web目录
         */
        InputStream resourceAsStream = servletContext.getResourceAsStream(downloadFilePath);
        byte[] buffer = new byte[1024 * 10];
        // 获取响应的输出流
        OutputStream outputStream = resp.getOutputStream();
        // 3. 把下载的文件内容回传给客户端

        // 读取输入流种全部的数据，复制给输出流，输出给客户端
        IOUtils.copy(resourceAsStream, outputStream);


    }
}
