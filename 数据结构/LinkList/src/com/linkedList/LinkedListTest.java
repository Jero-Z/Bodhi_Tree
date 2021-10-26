package com.linkedList;

import com.List;
import org.junit.Test;

public class LinkedListTest {


    private static class Person {
        final String name;
        final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person";
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
            return "School";
        }
    }

    @Test
    public void testLinkList() {
        System.out.println("双向链表");
        System.out.println("----添加----");
        List<Object> linkList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkList.add(i);
        }
        System.out.println(linkList);
        Person person = new Person("张三", 12);
        School school = new School("北京市", "实验小学");
        linkList.add(person);
        linkList.add(school);
        System.out.println(linkList);
        linkList.add(2, 33);
        System.out.println(linkList);

        Object remove = linkList.remove(0);
        System.out.println(remove);
        System.out.println(linkList);
        linkList.remove(linkList.size() - 1);
        System.out.println(linkList);

    }
}
