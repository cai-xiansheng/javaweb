package com.zh.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-09-07 19:36
 */
@Configuration
@ComponentScan(basePackages = {"com.zh"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigAop {
}
