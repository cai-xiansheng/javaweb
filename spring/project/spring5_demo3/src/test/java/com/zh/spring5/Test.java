package com.zh.spring5;

import com.zh.spring5.config.SpringConfig;
import com.zh.spring5.dao.UserDao;
import com.zh.spring5.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-09-06 21:00
 */
public class Test {

    @org.junit.Test
    public void test1() {
        ApplicationContext context= new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.add();
    }

    @org.junit.Test
    public void test2() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.add();
    }
}
