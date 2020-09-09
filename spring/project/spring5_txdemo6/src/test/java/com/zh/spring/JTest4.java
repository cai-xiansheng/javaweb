package com.zh.spring;

import com.zh.spring5.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-09-09 10:21
 */
@RunWith(SpringJUnit4ClassRunner.class) // 加载单元测试框架
@ContextConfiguration("classpath:bean1.xml") // 加载配置文件
public class JTest4 {

    @Autowired
    private UserService userService;

    @Test
    public void test1() {
        userService.accountMoney();
    }

}
