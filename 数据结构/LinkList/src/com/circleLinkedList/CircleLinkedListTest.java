package com.circleLinkedList;

import org.junit.Test;

public class CircleLinkedListTest {
    private record Person(String name, int age) {

        @Override
        public String toString() {
            return "Person";
        }
    }

    private record School(String address, String name) {

        @Override
        public String toString() {
            return "School";
        }
    }

    @Test
    public void testCircleLinkedList() {
        System.out.println("双向循环链表");
        System.out.println("----添加----");
        CircleLinkedList<Object> linkedList = new CircleLinkedList<>();
        for (int i = 0; i < 6; i++) {
            linkedList.add(i);
        }
        System.out.println(linkedList);
        Person person = new Person("张三", 12);
        School school = new School("北京市", "实验小学");
        linkedList.add(person);
        linkedList.add(school);
        System.out.println(linkedList);
        linkedList.add(2, 33);
        System.out.println(linkedList);

        linkedList.remove(0);
        System.out.println(linkedList);
        linkedList.remove(linkedList.size()-1);
        System.out.println(linkedList);
    }
}
