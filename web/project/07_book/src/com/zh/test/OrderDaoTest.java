package com.zh.test;

import com.zh.dao.OrderDao;
import com.zh.dao.impl.OrderDaoImpl;
import com.zh.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-22 13:51
 */
public class OrderDaoTest {

    @Test
    public void saveOrder() {

        OrderDao orderDao = new OrderDaoImpl();
        orderDao.saveOrder(new Order("1234567891", new Date(), new BigDecimal(100), 0, 1));

    }
}