package com.zh.spring5;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-09-07 13:34
 */
public class UserDaoImpl implements UserDao {
    public int add(int a, int b) {
        System.out.println("UserDaoImpl.add");
        return a + b;
    }

    public String update(String id) {
        System.out.println("UserDaoImpl.update");
        return id;
    }
}
