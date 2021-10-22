package com.linkedList;

import com.AbstractList;

/**
 * 双向链表
 *
 * @param <E>
 */
public class LinkedList<E> extends AbstractList<E> {
    private Node<E> first;
    private Node<E> last;

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        public Node(E element, Node<E> next, Node<E> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            if (prev != null) {
                sb.append(prev.element);
            } else {
                sb.append("null");
            }

            sb.append("_").append(element).append("_");

            if (next != null) {
                sb.append(next.element);
            } else {
                sb.append("null");
            }

            return sb.toString();
        }
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;

        return old;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if (index == size) {// 在最后位置添加
            Node<E> oldLast = last;
            last = new Node<>(element, null, oldLast);
            if (oldLast == null) {// 链表中没有节点元素
                first = last;
            } else {//有数据时，维护oldLast.next指向newLast
                oldLast.next = last;
            }
        } else {
            Node<E> node = node(index);
            Node<E> prev = node.prev;
            Node<E> newNode = new Node<>(element, node, prev);
            node.prev = newNode;

            if (prev == null) {
                first = newNode;
            } else {
                prev.next = newNode;
            }
        }
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);

        return null;
    }

    /**
     * 查找element在链表中的位置
     *
     * @param element
     * @return
     */
    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (node.element.equals(element)) return i;
                node = node.next;
            }
        }

        return ELEMENT_NOT_FOUND;
    }

    /**
     * 获取指定位置的节点
     *
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        rangeCheck(index);

        Node<E> node;
        if (index < (size >> 1)) {// 在前半段
            node = this.first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {//在后半段
            node = this.last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;// 最终查找节点为node的上一个节点
            }
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }

            string.append(node);

            node = node.next;
        }
        string.append("]");
        return string.toString();
    }
}
