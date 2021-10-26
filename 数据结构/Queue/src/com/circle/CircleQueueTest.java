package com.circle;

import org.junit.Test;

public class CircleQueueTest {
    @Test
    public void testCircleQueue() {
        CircleQueue<Object> circleQueue = new CircleQueue<>();

        for (int i = 0; i < 10; i++) {

            circleQueue.enQueue(i);
        }

        System.out.println(circleQueue);
        circleQueue.deQueue();
        circleQueue.deQueue();
        circleQueue.deQueue();
        circleQueue.deQueue();
        System.out.println(circleQueue);
    }
}
