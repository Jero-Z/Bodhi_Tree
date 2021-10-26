package com.stack;

import com.ArrayList.ArrayList;

/**
 * 栈
 * <p>
 * first in last out
 *
 * @param <E>
 */
public class Stack<E> {
    /**
     * func：
     * <p>
     * put
     * pop
     * clear
     * size
     * isEmpty
     * peek
     */

    private final ArrayList<E> list = new ArrayList<>();

    public void clear() {
        list.clear();
    }

    public void put(E element) {
        list.add(element);
    }

    public E pop() {
        return list.remove(list.size() - 1);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public E peek() {

        return list.get(list.size() - 1);
    }


}
