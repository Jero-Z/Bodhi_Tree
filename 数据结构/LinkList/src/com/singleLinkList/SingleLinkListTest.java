package com.singleLinkList;

import com.List;
import org.junit.Test;

public class SingleLinkListTest {

    private static class Person {
        final String name;
        final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    private static class School {
        final String address;
        final String name;

        public School(String address, String name) {
            this.address = address;
            this.name = name;
        }

        @Override
        public String toString() {
            return "School{" +
                    "address='" + address + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    @Test
    public void testSingleLinkList() {
        System.out.println("----单向链表----");
        System.out.println("----添加操作----");
        List<Object> linkList = new SingleLinkList<>();
        for (int i = 0; i < 10; i++) {
            linkList.add(i);
        }
        System.out.println(linkList);
        System.out.println("----删除----");
        linkList.remove(0);
        linkList.remove(0);
        linkList.remove(0);
        linkList.remove(linkList.size() - 1);
        System.out.println("----删除后----");
        System.out.println(linkList);
        Person person = new Person("张三", 12);
        School school = new School("北京市", "实验小学");

        linkList.add(person);
        linkList.add(school);
        System.out.println(linkList);
        linkList.add(1,22);
        System.out.println(linkList);
    }
}
