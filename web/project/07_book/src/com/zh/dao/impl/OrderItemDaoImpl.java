package com.zh.dao.impl;

import com.zh.dao.OrderItemDao;
import com.zh.pojo.OrderItem;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-22 13:41
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(name, count, price, total_price, order_id) values (?, ?, ?, ?, ?)";
        return update(sql, orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }
}
