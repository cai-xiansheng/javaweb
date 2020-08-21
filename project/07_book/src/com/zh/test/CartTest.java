package com.zh.test;

import com.zh.pojo.Cart;
import com.zh.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-21 13:54
 */
public class CartTest {

    private Cart cart = new Cart();

    @Test
    public void addItem() {
        cart.addItem(new CartItem(1,"母猪的产后护理", 1, new BigDecimal(99.99), new BigDecimal(99.99)));
        cart.addItem(new CartItem(2,"数据结构", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(1,"母猪的产后护理", 1, new BigDecimal(99.99), new BigDecimal(99.99)));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        cart.addItem(new CartItem(1,"母猪的产后护理", 1, new BigDecimal(99.99), new BigDecimal(99.99)));
        cart.addItem(new CartItem(2,"数据结构", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(1,"母猪的产后护理", 1, new BigDecimal(99.99), new BigDecimal(99.99)));
        cart.deleteItem(2);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        cart.addItem(new CartItem(1,"母猪的产后护理", 1, new BigDecimal(99.99), new BigDecimal(99.99)));
        cart.addItem(new CartItem(2,"数据结构", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(1,"母猪的产后护理", 1, new BigDecimal(99.99), new BigDecimal(99.99)));
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        cart.addItem(new CartItem(1,"母猪的产后护理", 1, new BigDecimal(99.99), new BigDecimal(99.99)));
        cart.addItem(new CartItem(2,"数据结构", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(1,"母猪的产后护理", 1, new BigDecimal(99.99), new BigDecimal(99.99)));
        cart.updateCount(1,9);
        System.out.println(cart);
    }
}