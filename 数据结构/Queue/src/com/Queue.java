package com;

import com.list.LinkedList;

/**
 * 单向队列
 *
 * @param <E>
 */
public class Queue<E> {

    /**
     * 队列方法：
     * enqueue
     * dequeue
     * size
     * isEmpty
     * peek
     * clear
     */
    LinkedList<E> list = new LinkedList<>();

    public void enqueue(E element) {
        list.add(element);
    }

    public E dequeue() {
        return list.remove(0);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public E peek() {
        return list.get(0);
    }

    public void clear() {
        list.clear();
    }
}
