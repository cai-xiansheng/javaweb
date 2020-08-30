package com.zh.servlet;


import com.google.gson.Gson;
import com.zh.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-24 20:21
 */
public class AjaxServlet extends BaseServlet {

    protected void javaScriptAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Ajax请求来了");
        Person person = new Person(1, "cc");

        // json格式的字符串

        Gson gson = new Gson();


        // toJson方法 可以把Java对象转化为json字符串
        String personJsonString = gson.toJson(person);
        System.out.println(personJsonString);
        resp.getWriter().write(personJsonString);
    }


    protected void jQueryAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQueryAjax");
        Person person = new Person(1, "cc");

        // json格式的字符串

        Gson gson = new Gson();


        // toJson方法 可以把Java对象转化为json字符串
        String personJsonString = gson.toJson(person);
        resp.getWriter().write(personJsonString);
    }


    protected void jQueryGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQueryGet");
        Person person = new Person(1, "cc");

        // json格式的字符串

        Gson gson = new Gson();


        // toJson方法 可以把Java对象转化为json字符串
        String personJsonString = gson.toJson(person);
        resp.getWriter().write(personJsonString);
    }


    protected void jQueryPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQueryPost");
        Person person = new Person(1, "cc");

        // json格式的字符串

        Gson gson = new Gson();


        // toJson方法 可以把Java对象转化为json字符串
        String personJsonString = gson.toJson(person);
        resp.getWriter().write(personJsonString);
    }




    protected void jQueryJson(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQueryJson");
        Person person = new Person(1, "cc");

        // json格式的字符串

        Gson gson = new Gson();


        // toJson方法 可以把Java对象转化为json字符串
        String personJsonString = gson.toJson(person);
        resp.getWriter().write(personJsonString);
    }



    protected void jQuerySerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQuerySerialize");
        System.out.println("用户名：" + req.getParameter("username"));
        System.out.println("password：" + req.getParameter("password"));
        Person person = new Person(1, "cc");

        // json格式的字符串

        Gson gson = new Gson();


        // toJson方法 可以把Java对象转化为json字符串
        String personJsonString = gson.toJson(person);
        resp.getWriter().write(personJsonString);
    }
}
