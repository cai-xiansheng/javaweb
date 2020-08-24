package com.zh.threadLocal;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-24 1:04
 */
public class OrderService {

    public void createOrder() {
        String name = Thread.currentThread().getName();
        System.out.println("OrderService当前线程"+ name +"中保存的数据是：" + ThreadLocalTest.threadLocal.get());
    }

}
