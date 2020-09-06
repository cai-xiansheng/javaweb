package com.zh.spring5.bean;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-09-06 16:40
 */
public class Emp {
    private String ename;
    private String gender;
    // 员工属于某一个部门，使用对象形式表示
    private Dept dept;

    public Dept getDept() {
        return dept;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void add() {
        System.out.println("Emp.add" + ename + " _" + gender + "---" + dept);
    }
}
