package com.zh.test;

import com.zh.dao.UserDao;
import com.zh.dao.impl.UserDaoImpl;
import com.zh.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-13 16:52
 */
public class UserDaoTest {

    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        String username = "admin";
        if (userDao.queryUserByUsername(username) == null) {
            System.out.println("用户名可用！");
        } else {
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        User user = userDao.queryUserByUsernameAndPassword("admin", "admin");
        if (user == null) {
            System.out.println("用户名或者密码错误，登陆失败");
        } else {
            System.out.println("登录成功");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null,"asdf", "123456", "wew@qq.com")));
    }
}