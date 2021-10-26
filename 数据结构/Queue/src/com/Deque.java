package com;

import com.list.LinkedList;
import com.list.List;

import java.util.NoSuchElementException;

/**
 * 双向队列
 *
 * @param <E>
 */
public class Deque<E> {

    final List<E> list = new LinkedList<>();

    /**
     * 队列中元素数量
     *
     */
    public int size() {
        return list.size();
    }

    /**
     * 队列是否为空
     *
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 添加到头部
     *
     */
    public void addFirst(E e) {
        list.add(0, e);
    }

    /**
     * 添加到尾部
     *
     */
    public void addLast(E e) {
        list.add(e);
    }


    /**
     * 获取头部数据(如果为null 返回异常)
     *
     */
    public E getFirst() {
        E e = list.get(0);
        if (e == null) {
            throw new NoSuchElementException();
        }
        return e;
    }


    /**
     * 获取尾部数据(如果为null 返回异常)
     *
     */
    public E getLast() {
        E e = list.get(list.size() - 1);
        if (e == null) {
            throw new NoSuchElementException();
        }
        return e;
    }


    /**
     */
    public E peekFirst() {
        return list.get(0);
    }

    /**
     * 获取尾部数据(如果列表为空则返回null)
     *
     */
    public E peekLast() {
        return list.get(list.size() - 1);
    }

    /**
     * 获取尾部数据(如果列表为空则返回null)
     *
     */
    public E pollLast() {
        return list.remove(0);
    }

    /**
     * 头部出队(列表为空则返回null)
     *
     */
    public E pollFirst() {
        return list.remove(list.size() - 1);
    }

    /**
     * NoTouchElementException–如果此列表为空
     *
     */
    public E removeLast() {
        E e = list.remove(list.size() - 1);
        if (e == null) {
            throw new NoSuchElementException();
        }
        return e;
    }

    /**
     * NoTouchElementException–如果此列表为空
     *
     */
    public E removeFirst() {
        E e = list.remove(0);
        if (e == null) {
            throw new NoSuchElementException();
        }
        return e;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Deque{list=");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            builder.append("[").append(list.get(i)).append("]");
        }
        builder.append("};");
        return builder.toString();
    }
}
