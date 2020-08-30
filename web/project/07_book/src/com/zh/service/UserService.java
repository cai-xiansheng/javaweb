package com.zh.service;

import com.zh.pojo.User;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-13 17:10
 */
public interface UserService {

    /**
     * 注册用户
     * @param user 用户信息
     */
    public void registerUser(User user);

    /**
     * 登录
     * @param user 用户信息
     * @return 如果返回null，说明登录失败，返回有值，是登录成功
     */
    public User login(User user);

    /**
     * 检查用户名是否可用
     * @param username 用户名
     * @return 返回true表示用户名已存在，返回false表示用户名可用
     */
    public Boolean existsUsername(String username);

}
