package com.zh.test;

import com.zh.dao.OrderItemDao;
import com.zh.dao.impl.OrderItemDaoImpl;
import com.zh.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-22 13:51
 */
public class OrderItemDaoTest {

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao = new OrderItemDaoImpl();
        orderItemDao.saveOrderItem(new OrderItem(1,"cc",1,new BigDecimal(100),new BigDecimal(100),"1234567890"));
    }
}