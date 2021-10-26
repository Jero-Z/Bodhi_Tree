package com.circle;

import org.junit.Test;

public class CircleDequeTest {
    @Test
    public void testCircleDeque() {
        CircleDeque<Object> circleDeque = new CircleDeque<>();

        for (int i = 0; i < 10; i++) {
            circleDeque.enQueueFront(i);
        }

        System.out.println(circleDeque);


        Object queueRear = circleDeque.deQueueRear();
        System.out.println(queueRear);
        circleDeque.deQueueRear();
        circleDeque.deQueueRear();
        circleDeque.deQueueRear();
        Object o = circleDeque.deQueueFront();
        System.out.println(o);
        circleDeque.deQueueFront();
        circleDeque.deQueueFront();
        circleDeque.deQueueFront();
        System.out.println(circleDeque);
    }
}
