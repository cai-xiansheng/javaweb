package com.zh.test;

import com.zh.pojo.Cart;
import com.zh.pojo.CartItem;
import com.zh.service.OrderService;
import com.zh.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-22 15:54
 */
public class OrderServiceTest {

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"母猪的产后护理", 1, new BigDecimal(99.99), new BigDecimal(99.99)));
        cart.addItem(new CartItem(2,"数据结构", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(1,"母猪的产后护理", 1, new BigDecimal(99.99), new BigDecimal(99.99)));
        OrderService orderService = new OrderServiceImpl();

        System.out.println(orderService.createOrder(cart,1));

    }
}