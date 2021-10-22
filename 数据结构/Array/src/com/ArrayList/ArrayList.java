package com.ArrayList;


import java.util.Arrays;

@SuppressWarnings("unchecked")

public class ArrayList<E> {

    private int size;

    private E[] elements;

    private static final int DEFAULT_CAPACITY = 10;
    private static final int ELEMENT_NOT_FOUND = -1;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capacity) {
        capacity = Math.max(capacity, DEFAULT_CAPACITY);
        this.elements = (E[]) new Object[capacity];
    }

    /**
     * 添加元素到数组中
     *
     * @param e e
     * @return boolean
     */
    public boolean add(E e) {
        return add(size, e);
    }

    /**
     * 查看元素是否在数组中
     *
     * @param element
     * @return boolean
     */
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * 在指定位置添加元素
     *
     * @param index
     * @param e
     * @return boolean
     */
    public boolean add(int index, E e) {
        rangeCheckForAdd(index);
        ensureCapacity(index + 1);//动态扩容
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }

        elements[index] = e;
        size++;
        return true;
    }

    /**
     * 删除指定位置的元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        rangeCheck(index);
        E old = elements[index];
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        elements[--size] = null;
        dynamicRecycle();
        return old;
    }

    /**
     * 在index位置插入一个元素
     *
     * @param index
     * @param element
     * @return
     */
    public E set(int index, E element) {
        rangeCheck(index);
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    /**
     * 获取指定位置数据
     *
     * @param index
     * @return E
     */
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    /**
     * 返回数组是否为空
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取数组元素个数
     *
     * @return int
     */
    public int size() {
        return this.size;
    }


    /**
     * 动态扩容
     *
     * @param capacity
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;// 容量足够

        int newCapacity = oldCapacity + (oldCapacity >> 1);//扩容1.5倍
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println("new capacity equals:" + newCapacity);
    }

    /**
     * 动态缩容
     */
    private void dynamicRecycle() {

        int oldCapacity = elements.length;

        int newCapacity = Math.max((oldCapacity >> 1), DEFAULT_CAPACITY);

        if (size > (newCapacity) || oldCapacity <= DEFAULT_CAPACITY) return;

        E[] newElements = (E[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;

        System.out.println("缩容为：" + newCapacity);
    }

    /**
     * 获取元素的位置
     *
     * @param element
     * @return int
     */
    public int indexOf(E element) {
        if (element == (null)) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return i;// 查找第一个为null的值
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (elements[i].equals(element)) return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }


    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    private void outOfBounds(int index) {
        throw new IndexOutOfBoundsException(System.out.printf("Index:%d,Size:%d", index, this.size).toString());
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }

            string.append(elements[i]);
        }
        string.append("]");
        return string.toString();
    }
}
