package com;

import org.junit.Test;

public class DequeTest {
    @Test
    public void testDeque() {
        Deque<Object> deque = new Deque<>();

        for (int i = 0; i < 10; i++) {
            deque.addFirst(i);
        }

        System.out.println(deque);
        for (int i = 10; i < 20; i++) {
            deque.addFirst(i);
        }
        System.out.println(deque);
        System.out.println("size=:" + deque.size());
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());

        deque.removeFirst();
        deque.removeFirst();
        deque.removeFirst();
        deque.removeFirst();
        deque.removeFirst();
        System.out.println(deque);
    }
}
