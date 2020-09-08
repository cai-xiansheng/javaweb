package com.zh.spring;

import com.zh.spring5.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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

}
