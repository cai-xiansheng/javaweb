package com.zh.service.impl;

import com.zh.dao.UserDao;
import com.zh.dao.impl.UserDaoImpl;
import com.zh.pojo.User;
import com.zh.service.UserService;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-13 17:16
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public Boolean existsUsername(String username) {
        if (userDao.queryUserByUsername(username) == null) {
            // 等于null说名没有查到
            return false;
        }
        return true;
    }
}
