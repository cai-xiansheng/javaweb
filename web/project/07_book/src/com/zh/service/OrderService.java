package com.zh.service;

import com.zh.pojo.Cart;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-22 15:37
 */
public interface OrderService {

    public String createOrder(Cart cart,Integer userId);

}
