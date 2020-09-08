package com.zh.spring5.service;

import com.zh.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-09-08 13:20
 */
@Service
public class UserService {

    // 注入dao
    @Autowired
    private UserDao userDao;

    public void accountMoney() {
        userDao.reduceMoney();
        userDao.addMoney();
    }

}
