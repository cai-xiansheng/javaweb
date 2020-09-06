package com.zh.spring5.bean;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-09-06 19:51
 */
public class Orders {


    public Orders() {
        System.out.println("第一步，执行无参构造创建bean实例");
    }

    private String oname;

    public void setOname(String oname) {
        System.out.println("第二步，调用set方法设置属性的值");
        this.oname = oname;
    }

    // 创建一个执行的初始化方法
    public void initMethod() {
        System.out.println("第三步，执行初始化的方法");
    }


    // 创建执行的销毁的方法
    public void destroyMethods() {
        System.out.println("第五步，执行销毁的方法");
    }

}
