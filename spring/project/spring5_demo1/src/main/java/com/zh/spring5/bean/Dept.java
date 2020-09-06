package com.zh.spring5.bean;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-09-06 16:40
 */
public class Dept {
    private String dname;



    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dname='" + dname + '\'' +
                '}';
    }
}
