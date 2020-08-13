package com.zh.test;

import com.zh.pojo.User;
import com.zh.service.UserService;
import com.zh.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-13 17:22
 */
public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registerUser() {
        userService.registerUser(new User(null,"cds","12414","afsdhfjk@qq.com"));
        userService.registerUser(new User(null,"cads","12414","afsdhfjk@qq.com"));

    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"admin","admin",null)));
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("fasd")) {
            System.out.println("用户名存在");
        } else {
            System.out.println("用户名可用");
        }
    }
}