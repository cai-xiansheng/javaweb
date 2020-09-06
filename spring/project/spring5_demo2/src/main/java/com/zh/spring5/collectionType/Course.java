package com.zh.spring5.collectionType;

import java.sql.SQLOutput;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-09-06 18:22
 */
public class Course {
    private String course;

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course='" + course + '\'' +
                '}';
    }
}
