package com.singleLinkList;

import com.AbstractList;

public class SingleLinkList<E> extends AbstractList<E> {

    private Node<E> first;

    private static class Node<E> {
        E element;// 节点中元素
        Node<E> next;// 下一个元素

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    /**
     * 设置指定位置的元素
     *
     * @param index
     * @param element
     * @return
     */
    @Override
    public E set(int index, E element) {
        rangeCheck(index);

        Node<E> node = node(index);

        E old = node.element;

        node.element = element;

        return old;
    }

    /**
     * 添加元素
     *
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        if (index == 0) {// 链表为空时添加到first中
            first = new Node<>(element, null);
        } else {
            Node<E> node = node(index - 1);

            node.next = new Node<>(element, node.next);
        }
        size++;
    }

    /**
     * 删除元素
     *
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = first;
        if (index == 0) {
            this.first = first.next;
        } else {
            Node<E> prev = node(index - 1);//获取要删除的上一个节点
            node = prev.next;
            prev.next = node.next;
        }
        size--;
        return node.element;
    }

    /**
     * 查找元素所在位置
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
                //更改node
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) return i;
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

        Node<E> node = first;

        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("size=").append(size).append(",[");
        Node<E> node = this.first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                builder.append(", ");
            }
            builder.append(node.element);
            node = node.next;
        }
        builder.append("]");
        return builder.toString();
    }
}
