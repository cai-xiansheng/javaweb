package com.zh.spring5;

import com.zh.spring5.autoWire.Emp;
import com.zh.spring5.bean.Orders;
import com.zh.spring5.collectionType.Book;
import com.zh.spring5.collectionType.Course;
import com.zh.spring5.collectionType.Stu;
import com.zh.spring5.factoryBean.MyBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-09-06 18:14
 */
public class Test {

    @org.junit.Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Stu stu = context.getBean("stu", Stu.class);
        stu.test();
    }

    @org.junit.Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Book book = context.getBean("book", Book.class);
        Book book2 = context.getBean("book", Book.class);
        System.out.println(book);
        System.out.println(book2);
    }

    @org.junit.Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Course myBean = context.getBean("myBean", Course.class);
        System.out.println(myBean);
    }

    @org.junit.Test
    public void test4() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println("第四步，获取到了创建bean对象");
        System.out.println(orders);

        // 手动让bean实例销毁
        ((ClassPathXmlApplicationContext) context).close();
    }


    @org.junit.Test
    public void test5() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
        emp.test();

    }


}
