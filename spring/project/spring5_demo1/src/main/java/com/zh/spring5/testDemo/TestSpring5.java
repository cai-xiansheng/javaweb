package com.zh.spring5.testDemo;

import com.zh.spring5.Book;
import com.zh.spring5.Orders;
import com.zh.spring5.User;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-30 15:36
 */
public class TestSpring5 {

    @Test
    public void testAdd() {
        // 1. 加载Spring配置文件
        BeanFactory context = new ClassPathXmlApplicationContext("bean1.xml");

        // 2. 获取配置创建的对象
        User user = context.getBean("user", User.class);

        System.out.println(user);
        user.add();

    }

    @Test
    public void testBook() {
        // 1. 加载Spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        // 2. 获取配置创建的对象
        Book book = context.getBean("book", Book.class);

        System.out.println(book);
        book.testDemo();

    }

    @Test
    public void testOrders() {
        // 1. 加载Spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        // 2. 获取配置创建的对象
        Orders orders = context.getBean("orders", Orders.class);

        System.out.println(orders);
        orders.ordersTest();

    }
}
