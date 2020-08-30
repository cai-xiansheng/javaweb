package com.zh.servlet;

import com.zh.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-14 18:13
 */
public class SearchStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求参数

        // 发sql语句

        // 使用for循环生成查询到的数据做模拟
        List<Student> studentList = new ArrayList<Student>();
        for (int i = 0; i < 10; i++) {
            studentList.add(new Student(i + 1, "name" + i, 18 + i, "phone" + i));
        }

        // 保存查询到的结果（学生信息）到request域中
        req.setAttribute("studentList", studentList);
        // 请求转发到showStudent.jsp页面中
        req.getRequestDispatcher("/test/showStudent.jsp").forward(req, resp);

    }
}
