package com.zh.spring5.aopanno;

import org.springframework.stereotype.Component;

/**
 * @author cai-xiansheng
 * @Description 被增强的类
 * @create 2020-09-07 17:33
 */
@Component
public class User {

    public void add() {
        System.out.println("User.add");
    }

}
