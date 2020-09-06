package com.zh.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-09-06 21:56
 */
@Configuration // 作为配置类，代替xml配置文件
@ComponentScan(basePackages = {"com.zh.spring5"}) // 配置扫描注解的范围
public class SpringConfig {

}
