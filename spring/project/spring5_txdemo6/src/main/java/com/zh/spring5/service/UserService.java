package com.zh.spring5.service;

import com.zh.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-09-08 13:20
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, timeout = -1)
public class UserService {

    // 注入dao
    @Autowired
    private UserDao userDao;


    public void accountMoney() {

        //try {
            // 第一步，开启事务

            // 第二步，进行业务操作

            userDao.reduceMoney();

            // 模拟异常
            //int i = 10 / 0;

            userDao.addMoney();

            // 第三步，没有发生异常，提交事务

        //} catch (Exception e) {
            // 第四步，如果出现了异常，事务回滚

            //e.printStackTrace();
        //}
    }

}
