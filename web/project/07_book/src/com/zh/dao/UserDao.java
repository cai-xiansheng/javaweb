package com.zh.dao;

import com.zh.pojo.User;

/**
 * @author cai-xiansheng
 * @Description UserDao
 * @create 2020-08-13 16:37
 */
public interface UserDao {

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 如果返回null，说明没有这个用户，反之亦然
     */
    public User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户信息
     * @param username 用户名
     * @param password 密码
     * @return 如果返回null，说明用户名或者密码错误，反之亦然
     */
    public User queryUserByUsernameAndPassword(String username,String password);

    /**
     * 保存用户信息
     * @param user 用户信息
     * @return 返回-1表示操作失败，其他是sql语句影响的行数
     */
    public int saveUser(User user);

}
