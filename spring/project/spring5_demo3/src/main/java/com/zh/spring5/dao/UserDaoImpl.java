package com.zh.spring5.dao;

import org.springframework.stereotype.Repository;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-09-06 21:36
 */
@Repository(value = "userDaoImpl1")
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("UserDaoImpl.add");
    }
}
