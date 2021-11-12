package com.tree.rbTree;


import com.printer.BinaryTrees;
import org.junit.jupiter.api.Test;

class RBTreeTest {

    @Test
    public void testRBTreeAdd() {
        Integer data[] = new Integer[]{
                67, 52, 92, 96, 53, 95, 13, 63, 34, 82, 76, 54, 9, 68, 39
        };
        RBTree<Object> rbTree = new RBTree<>();

        for (Integer item : data) {
            rbTree.add(item);
        }


        BinaryTrees.println(rbTree);
    }

    @Test
    public void testRBTreeRemove() {
        Integer data[] = new Integer[] {
                55, 87, 56, 74, 96, 22, 62, 20, 70, 68, 90, 50
        };

        RBTree<Integer> rb = new RBTree<>();
        for (int i = 0; i < data.length; i++) {
            rb.add(data[i]);
            System.out.println("【" + data[i] + "】");
            BinaryTrees.println(rb);
            System.out.println("---------------------------------------");
        }
    }
}