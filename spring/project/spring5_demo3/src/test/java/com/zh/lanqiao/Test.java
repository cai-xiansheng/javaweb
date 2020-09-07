package com.zh.lanqiao;

import java.util.*;

/**
 * @author cai-xiansheng
 * @Description
 * @create 2020-09-07 8:29
 */
public class Test {


    @org.junit.Test
    public void test5() {


        int n = 40;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (Test.check(i)) {
                sum += i;
            }
        }
        System.out.println(sum);

    }
    public static Boolean check(int i) {
        char[] chars = String.valueOf(i).toCharArray();
        for (int j = 0; j < chars.length; j++) {
            if (chars[j] == '2' || chars[j] == '0' || chars[j] == '1' || chars[j] == '9') {
                return true;
            }
        }
        return false;
    }


    @org.junit.Test
    public void test3() {

        System.out.println(subSum("0100110001010001"));
        System.out.println(subSum("aaab"));
    }

    public int subSum(String string) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            for (int j = i; j < string.length(); j++) {
                // 将每一个子串都加入到set集合中
                set.add(string.substring(i, j + 1));
            }
        }
        return set.size();
    }


    @org.junit.Test
    public void test4() {
        System.out.println(lastNums(20190324));
    }

    public int lastNums(int target) {
        long start = System.currentTimeMillis();
        int a = 1;
        int b = 1;
        int c = 1;
        for (int i = 4; i <= target; i++) {

            if(i % 3 == 1) {
                a = (a + b + c) % 10000;
            }else if(i % 3 == 2) {
                b = (a + b + c) % 10000;
            }else {
                c = (a + b + c) % 10000;
            }

            //int flag = i % 3;
            //switch (flag) {
            //    case 1:
            //        a = (a + b + c) % 10000;
            //        break;
            //    case 2:
            //        b = (a + b + c) % 10000;
            //        break;
            //    default:
            //        c = (a + b + c) % 10000;
            //        break;
            //}
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        if (target % 3 == 1) {
            return a;
        } else if (target % 3 == 2) {
            return b;
        } else {
            return c;
        }

    }


    @org.junit.Test
    public void test1() {
        HashSet<String> set = new HashSet<>();
        System.out.println(set.add("f"));
        System.out.println(set.add("f"));
        set.add("a");
        set.add("a");
        set.add("b");
        set.add("b");
        set.add("d");
        set.add("d");
        // 增强for循环
        for (String string : set) {
            System.out.println(string);
        }
    }


    @org.junit.Test
    public void test2() {

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(66);
        treeSet.add(66);
        treeSet.add(22);
        treeSet.add(77);
        treeSet.add(11);
        treeSet.add(11);
        System.out.println(treeSet);
    }


    @org.junit.Test
    public void testSet() {
        Set set = new HashSet();
    }


    //public static void main(String[] args) {
    //    ArrayList<String> list = new ArrayList<>();
    //    list.add("a");
    //    list.add("a");
    //    list.add("b");
    //    list.add("b");
    //    list.add("c");
    //    list.add("c");
    //    list.add("d");
    //    list.add("d");
    //    System.out.println(list);
    //    HashSet<String> set = new HashSet<>();
    //    set.addAll(list);
    //    System.out.println(set);
    //    list.clear();  // 清空原有元素 放入被list去重后的元素
    //    list.addAll(set);
    //    System.out.println(list);
    //}
    public static void main(String[] args) {
        HashSet<Person1> hashSet = new HashSet<>();
        System.out.println(hashSet.add(new Person1("吕布", 25)));
        System.out.println(hashSet.add(new Person1("吕布", 25)));
        hashSet.add(new Person1("关羽", 26));
        hashSet.add(new Person1("关羽", 26));
        hashSet.add(new Person1("赵云", 23));
        hashSet.add(new Person1("赵云", 23));
        for (Person1 person1 : hashSet) {
            System.out.println(person1);
        }
    }


}

class Person1 {
    private String name;
    private Integer age;

    public Person1(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}