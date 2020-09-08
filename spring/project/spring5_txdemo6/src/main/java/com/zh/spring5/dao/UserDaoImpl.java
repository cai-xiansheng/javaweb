package com.zh.spring5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-09-08 13:20
 */
@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void reduceMoney() {
        String sql = "update t_account set money = money - ? where username = ?";
        jdbcTemplate.update(sql, 100, "lucy");
    }

    public void addMoney() {
        String sql = "update t_account set money = money + ? where username = ?";
        jdbcTemplate.update(sql,100, "mary");
    }
}
