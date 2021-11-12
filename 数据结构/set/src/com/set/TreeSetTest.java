package com.set;

import org.junit.Test;

import static org.junit.Assert.*;

public class TreeSetTest {

    private final Set<Integer> set = new TreeSet<>();

    public TreeSetTest() {
        set.add(12);
        set.add(10);
        set.add(7);
        set.add(11);
        set.add(10);
        set.add(11);
        set.add(9);
    }

    @Test
    public void clear() {
        assertNotNull(set);
        set.clear();
        System.out.println(set.size());
        assertTrue(set.isEmpty());
    }

    @Test
    public void contains() {
        assertFalse(set.contains(8));
        assertTrue(set.contains(11));
        assertFalse(set.contains(91));
        set.traversal(new Set.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.println(element);
                return false;
            }
        });
    }

    @Test
    public void add() {

        set.add(22);
        set.add(22);
        set.add(23);
        assertEquals(7, set.size());
    }

    @Test
    public void remove() {

        set.remove(22);
        set.remove(23);

        assertEquals(5, set.size());

        assertFalse(set.isEmpty());
    }
}