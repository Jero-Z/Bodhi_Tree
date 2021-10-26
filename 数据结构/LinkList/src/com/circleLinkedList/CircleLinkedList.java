package com.circleLinkedList;

import com.AbstractList;

/**
 * 双向循环链表
 *
 * @param <E>
 */
public class CircleLinkedList<E> extends AbstractList<E> {
    private Node<E> first;
    private Node<E> last;
    private Node<E> current;//当前链表中的首结点的位置

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

    public void reset() {
        current = first;
    }

    /**
     * 获取当前链表中的下一个节点数据
     *
     */
    public E next() {
        if (current == null) return null;

        current = current.next;
        return current.element;
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        Node<E> node = node(index);
        E oldElement = node.element;
        node.element = element;
        return oldElement;
    }

    /**
     * 添加节点
     *
     */
    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if (index == size) {//最后添加数据
            Node<E> oldLast = last;//先将原有的最后一个节点保存下来
            last = new Node<>(element, first, oldLast);
            if (oldLast == null) {//链表的第一个元素
                first = last;
                first.next = first;
                first.prev = first;
            } else {
                oldLast.next = last;//旧last节点next = new last
                first.prev = last;
            }
        } else {
            Node<E> next = node(index);
            Node<E> prev = next.prev;
            Node<E> node = new Node<>(element, next, prev);
            next.prev = node;
            prev.next = node;

            if (next == first) first = node;
        }
        size++;

    }

    @Override
    public E remove(int index) {
        /*
          删除双向链表节点数据

          两种情况：
          删除的是最后一个 size == 1
          删除的其他的
         */
        rangeCheck(index);
        Node<E> node = node(index);
        if (size == 1) {
            first = null;
            last = null;
        } else {


            Node<E> prev = node.prev;
            Node<E> next = node.next;
            prev.next = next;
            next.prev = prev;

            if (node == first) {//删除的是首个节点
                first = next;
            }
            if (node == last) {
                last = prev;
            }
        }
        size--;

        return node.element;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }


    /**
     * 获取指定位置的节点数据
     * <p>
     * 通过头尾部指针折中获取
     *
     */
    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node;

        if (index < (size >> 1)) {
            node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }

        } else {
            node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
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
