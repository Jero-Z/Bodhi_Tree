package com.set;

import java.util.LinkedList;
import java.util.List;

public class ListSet<E> implements Set<E> {
    private final List<E> list = new LinkedList<>();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public boolean contains(E element) {
        return list.contains(element);
    }

    @Override
    public void add(E element) {
        int index = list.indexOf(element);

        if (index != -1) {
            list.set(index, element);
        } else {
            list.add(element);
        }
    }

    @Override
    public void remove(E element) {
        int index = list.indexOf(element);
        if (index != -1) {
            list.remove(element);
        }
    }

    @Override
    public void traversal(Visitor<E> visitor) {
        if (visitor == null) return;

        for (E e : list) {
            if (visitor.visit(e)) return;
        }
    }
}
