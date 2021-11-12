package com.set;


import org.junit.Test;

public class ListSetTest {


    private final Set<Object> set = new ListSet<>();

    public ListSetTest() {
        for (int i = 0; i < 20; i++) {
            set.add(i);
        }

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
    }

    @Test
    public void testAdd() {
        set.add(19);
        set.traversal(new Set.Visitor<Object>() {
            @Override
            public boolean visit(Object element) {
                System.out.println(element);
                return false;
            }
        });
    }

    @Test
    public void testRemove() {
        set.remove(10);
        set.remove(10);
        set.remove(10);


        System.out.println("remove after equals:-------");
        set.traversal(new Set.Visitor<Object>() {
            @Override
            public boolean visit(Object element) {
                System.out.println(element);
                return false;
            }
        });
    }
}