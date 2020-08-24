package com.zh.service.impl;

import com.zh.dao.BookDao;
import com.zh.dao.OrderDao;
import com.zh.dao.OrderItemDao;
import com.zh.dao.impl.BookDaoImpl;
import com.zh.dao.impl.OrderDaoImpl;
import com.zh.dao.impl.OrderItemDaoImpl;
import com.zh.pojo.*;
import com.zh.service.OrderService;

import java.util.Date;
import java.util.Map;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-22 15:41
 */
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        // 订单编号：唯一性
        String orderId = System.currentTimeMillis() + "" + userId;
        // 创建了一个订单对象
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        // 保存订单
        orderDao.saveOrder(order);

        int i= 10/0;

        // 遍历购物车中每一个商品项转换成为订单项保存到数据库
        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
            // 获取每一个购物车中的商品项，
            CartItem cartItem = entry.getValue();
            // 转换为每一个订单项
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderId);
            // 保存订单项到数据项
            orderItemDao.saveOrderItem(orderItem);
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales() + cartItem.getCount());
            book.setStock(book.getStock() - cartItem.getCount());
            bookDao.updateBook(book);
        }
        // 清空购物车
        cart.clear();

        return orderId;
    }
}
