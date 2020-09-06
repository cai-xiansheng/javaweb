package com.zh.spring5.service;

import com.zh.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-09-06 21:11
 */
/**
 * <bean id="userService" class="...">
 * 在注解里面value属性值可以省略不写，
 * 默认值是类名称，首字母小写
 */
//@Component(value = "userService")
@Service
public class UserService {

    @Value(value = "abc")
    private String name;


    // 定义dao类型属性
    // 不需要添加set方法
    //@Autowired // 根据类型进行注入
    //@Qualifier(value = "userDaoImpl1") // 根据名称进行注入
    //private UserDao userDao;

    //@Resource // 根据类型进行注入
    @Resource(name = "userDaoImpl1") // 根据名称进行注解
    private UserDao userDao;


    public void add() {
        System.out.println("UserService.add:name=" + name);
        userDao.add();
    }

}
