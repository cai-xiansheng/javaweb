package com.zh.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zh.pojo.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-08-24 19:52
 */
public class JsonTest {

    //### JavaBean和json的互转
    @Test
    public void test1() {
        Person person = new Person(1, "cc");

        // 创建gson对象实例
        Gson gson = new Gson();


        // toJson方法 可以把Java对象转化为json字符串
        String personJsonString = gson.toJson(person);
        System.out.println(personJsonString);

        // fromJson把json字符串转换回Java对象
        // 第一个参数是json字符串
        // 第二个参数是转换回去的Java对象类型
        Person person1 = gson.fromJson(personJsonString, Person.class);
        System.out.println(person1);
    }


    //### List和json的互转
    @Test
    public void test2() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "cc"));
        personList.add(new Person(2, "aa"));
        Gson gson = new Gson();
        String persionJsonString = gson.toJson(personList);
        System.out.println(persionJsonString);

        List<Person> list = gson.fromJson(persionJsonString, new PersonListType().getType());
        System.out.println(list);
        Person person = list.get(0);
        System.out.println(person);
    }


    //### map和json的互传
    @Test
    public void test3() {
        Map<Integer, Person> personMap = new HashMap<>();
        personMap.put(1, new Person(1, "cc"));
        personMap.put(2, new Person(2, "aa"));

        Gson gson = new Gson();
        // 把map集合转换成json字符串
        String personMapJsonString = gson.toJson(personMap);
        System.out.println(personMapJsonString);

        //Map<Integer, Person> personMap1 = gson.fromJson(personMapJsonString, new PersonMapType().getType());
        // 使用匿名内部类
        Map<Integer, Person> personMap1 = gson.fromJson(personMapJsonString, new TypeToken<Map<Integer, Person>>() {
        }.getType());
        System.out.println(personMap1);
        System.out.println(personMap1.get(1));
    }

}
