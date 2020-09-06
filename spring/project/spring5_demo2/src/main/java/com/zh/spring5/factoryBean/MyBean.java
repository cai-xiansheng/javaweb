package com.zh.spring5.factoryBean;

import com.zh.spring5.collectionType.Course;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-09-06 19:28
 */
public class MyBean implements FactoryBean<Course> {

    // 定义返回bean
    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setCourse("abc");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
