package com.zh.spring5;

/**
 * @author cai-xiansheng
 * @Description 使用有参数构造进行注入
 * @create 2020-09-06 15:49
 */
public class Orders {
    private String oname;
    private String address;

    public Orders(String oname, String address) {
        this.oname = oname;
        this.address = address;
    }

    public void ordersTest() {
        System.out.println(oname + "--" + address);
    }
}
