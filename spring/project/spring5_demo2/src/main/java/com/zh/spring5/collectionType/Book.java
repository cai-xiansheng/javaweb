package com.zh.spring5.collectionType;

import java.util.List;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-09-06 18:28
 */
public class Book {

    private List<String> list;

    public void setList(List<String> list) {
        this.list = list;
    }

    public void test() {
        System.out.println(list);
    }
}
