package com.zh.spring5.autoWire;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-09-06 20:16
 */
public class Emp {
    private Dept dept;

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "dept=" + dept +
                '}';
    }

    public void test() {
        System.out.println(dept);
    }
}
