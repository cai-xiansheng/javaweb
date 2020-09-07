package com.zh.spring5;

import com.zh.spring5.aopanno.User;
import com.zh.spring5.aopxml.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-09-07 18:16
 */
public class Test {

    @org.junit.Test
    public void testAopAnno() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }

    @org.junit.Test
    public void testAopXml() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Book book = context.getBean("book", Book.class);
        book.buy();
    }

}
