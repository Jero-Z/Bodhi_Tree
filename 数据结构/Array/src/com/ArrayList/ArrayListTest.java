package com.ArrayList;

import org.junit.Test;

public class ArrayListTest {
    private static class Person {
        int age;
        String name;

        public Person() {
            this.age = 28;
            this.name = "jack";
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    private static class Student {

        String name;
        String number;

        public Student() {
            this.name = "张三";
            this.number = "ox11011";
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", number='" + number + '\'' +
                    '}';
        }
    }

    @Test
    public void testArrayList() {
        ArrayList<Object> objectArrayList = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            objectArrayList.add(i);
        }
        System.out.println("现有数组内数据个数为：");
        System.out.println(objectArrayList.size());

        Person person = new Person();
        objectArrayList.add(person);
        Student student = new Student();
        objectArrayList.add(student);

        System.out.println("添加完毕后size:" + objectArrayList.size());
        int removeSize = objectArrayList.size();

        for (int i = 0; i < removeSize; i++) {
            objectArrayList.remove(objectArrayList.size() - 1);
        }
        System.out.println("--------");

        System.out.println(objectArrayList.size());
        System.out.println(objectArrayList);
    }

}
