package com.zh.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-09-09 9:58
 */
public class UserLog {

    private static final Logger log = LoggerFactory.getLogger(UserLog.class);

    @Nullable
    private String id;


    public static void main(String[] args){
        log.info("hello log4j2");
        log.warn("hello log4j2");
    }

}
