package com.zh.spring;

import com.zh.spring5.config.TxConfig;
import com.zh.spring5.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-09-08 13:19
 */
public class Test {

    @org.junit.Test
    public void test() {


        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }

    @org.junit.Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }


    @org.junit.Test
    public void test1() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }


    // 函数式风格
    @org.junit.Test
    public void testGenericApplicationContext() {
        // 1. 创建GenericApplicationContext对象
        GenericApplicationContext context = new GenericApplicationContext();
        // 2. 调用context的方法对象注册
        context.refresh();
        context.registerBean("user1",User.class, ()-> new User());

        // 3. 获取在Spring中注册的对象
        User user = (User) context.getBean("user1");
        System.out.println(user);
    }

}
