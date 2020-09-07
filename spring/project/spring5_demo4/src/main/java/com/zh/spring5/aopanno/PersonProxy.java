package com.zh.spring5.aopanno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-09-07 19:18
 */
@Component
@Aspect
@Order(1)
public class PersonProxy {


    // 前置通知
    // @Before注解表示作为前置通知
    @Before(value = "execution(* com.zh.spring5.aopanno.User.add(..))")
    public void before() {
        System.out.println("PersonProxy.before");
    }
}
