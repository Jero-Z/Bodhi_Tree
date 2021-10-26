package com.stack;

import org.junit.Test;

public class StackTest {

    @Test
    public void testStack() {
        Stack<Object> stack = new Stack<>();

        stack.put(1);
        stack.put(2);
        stack.put(3);
        stack.put(4);

        System.out.println("现有数据：" + stack.size() + "-----");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack.isEmpty());
    }
}
