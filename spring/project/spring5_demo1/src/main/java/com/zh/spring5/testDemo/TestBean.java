package com.zh.spring5.testDemo;

import com.zh.spring5.bean.Emp;
import com.zh.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-09-06 16:34
 */
public class TestBean {
    @Test
    public void Test1() {
        // 1. 加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");

        // 2. 获取配置创建的对象
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.add();
    }


    @Test
    public void Test2() {
        // 1. 加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");

        // 2. 获取配置创建的对象
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
        emp.add();
    }


    @Test
    public void Test3() {
        // 1. 加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");

        // 2. 获取配置创建的对象
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
        emp.add();
    }
}
