package com.zh.spring5.aopanno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author cai-xiansheng
 * @Description 增强的类
 * @create 2020-09-07 17:34
 */
@Component
@Aspect // 生成代理对象
public class UserProxy {

    // 相同切入点抽取
    @Pointcut(value = "execution(* com.zh.spring5.aopanno.User.add(..))")
    public void pointDemo() {
    }


    // 前置通知
    // @Before注解表示作为前置通知
    @Before(value = "pointDemo()")
    public void before() {
        System.out.println("UserProxy.before");
    }

    // 最终通知
    @After(value = "pointDemo()")
    public void after() {
        System.out.println("UserProxy.after");
    }

    // 返回通知（返回通知）
    @AfterReturning(value = "pointDemo()")
    public void afterReturning() {
        System.out.println("UserProxy.afterReturning");
    }

    // 异常通知
    @AfterThrowing(value = "pointDemo()")
    public void afterThrowing() {
        System.out.println("UserProxy.afterThrowing");
    }

    // 环绕通知
    @Around(value = "pointDemo()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("UserProxy.around之前");

        // 被增强的方法执行
        proceedingJoinPoint.proceed();

        System.out.println("UserProxy.around之后");
    }
}
