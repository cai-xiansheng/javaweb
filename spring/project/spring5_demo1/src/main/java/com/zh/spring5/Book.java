package com.zh.spring5;

/**
 * @author cai-xiansheng
 * @Description 演示使用set方法进行注入属性
 * @create 2020-09-06 10:52
 */
public class Book {

    private String bname;
    private String bauthor;
    private String address;

    /**
     * set方法注入
     * @param bname
     */
    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void testDemo() {
        System.out.println(bname + "---" + bauthor + "---" + address);
    }
}
