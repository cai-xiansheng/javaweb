package com.zh.dao.impl;

import com.zh.dao.OrderDao;
import com.zh.pojo.Order;

import java.sql.Date;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-22 13:38
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(order_id, create_time, price, status, user_id) values(?, ?, ?, ?, ?)";
        return update(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
    }
}
