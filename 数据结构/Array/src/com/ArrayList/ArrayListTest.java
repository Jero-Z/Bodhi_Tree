package com.ArrayList;

import org.junit.Test;

public class ArrayListTest {


    @Test
    public void contains() {
        ArrayList<Object> objectArrayList = new ArrayList<>();
        System.out.println(objectArrayList.contains(11));
    }

    @Test
    public void set() {
        ArrayList<Object> objectArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            objectArrayList.add(i);
        }
        System.out.println(objectArrayList.set(1, "123"));
        System.out.println(objectArrayList);
    }


    private static class Person {
        final int age;
        final String name;

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

        final String name;
        final String number;

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
