package com.zh.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-16 12:00
 */
public class UserServletTest {

    public void login() {
        System.out.println("UserServletTest.login");
    }

    public void register() {
        System.out.println("UserServletTest.register");
    }

    public void updateUser() {
        System.out.println("UserServletTest.updateUser");
    }

    public void updateUserPassword() {
        System.out.println("UserServletTest.updateUserPassword");
    }

    public static void main(String[] args) {
        String action ="login";
        try {
            // 通过action业务鉴别字符串，获取相应的业务，方法反射对象
            Method method = UserServletTest.class.getDeclaredMethod(action);
            //System.out.println(method);
            method.invoke(new UserServletTest());


        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
