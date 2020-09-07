package com.zh.spring5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-09-07 13:36
 */
public class JDKProxy {

    public static void main(String[] args) {
        // 创建接口实现类代理对象
        Class[] interfaces = {UserDao.class};
        //Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new InvocationHandler() {
        //    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //        return null;
        //    }
        //});
        UserDao userDao = new UserDaoImpl();
        UserDao userDao1 = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        System.out.println("执行结果" + userDao1.add(1, 2));
    }

}

// 创建代理对象的方法
class UserDaoProxy implements InvocationHandler{
    // 1. 把创建的是谁的代理对象，把谁传递过来
    // 有参构造
    private Object obj;

    public UserDaoProxy(Object obj) {
        this.obj = obj;
    }


    // 增强业务的逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 方法之前
        System.out.println("方法执行之前执行...." + method.getName() + " ....传递的而参数" + Arrays.toString(args));

        // 被增强的方法执行
        Object res = method.invoke(obj, args);


        // 方法执行之后执行
        System.out.println("方法执行之后输出。。。" + obj);


        return res;
    }
}