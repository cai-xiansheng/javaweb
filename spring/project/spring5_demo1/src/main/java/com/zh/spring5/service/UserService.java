package com.zh.spring5.service;

import com.zh.spring5.dao.UserDao;
import com.zh.spring5.dao.UserDaoImpl;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-09-06 16:22
 */
public class UserService {

    // 创建UserDao类型属性，生成set方法
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add() {
        System.out.println("service add >>>>>");
        userDao.update();

        // 原始方式：创建UserDao对象
        //UserDao userDao = new UserDaoImpl();
        //userDao.update();
    }

}
