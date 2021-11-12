package com.tree.rbTree;

import com.printer.BinaryTrees;
import org.junit.jupiter.api.Test;

class AVLTreeTest {

    @Test
    public void testAVLTreeAdd() {
        Integer data[] = new Integer[]{
                67, 52, 92, 96, 53, 95, 13, 63, 34, 82, 76, 54, 9, 68, 39
        };

        AVLTree<Integer> avl = new AVLTree<>();
        for (int i = 0; i < data.length; i++) {
            avl.add(data[i]);
        }

        BinaryTrees.println(avl);
    }

    @Test
    public void testAVLTreeRemove() {
        Integer data[] = new Integer[]{
                67, 52, 92, 96, 53, 95, 13, 63, 34, 82, 76, 54, 9, 68, 39
        };

        AVLTree<Integer> avl = new AVLTree<>();
        for (int i = 0; i < data.length; i++) {
            avl.add(data[i]);
        }

        BinaryTrees.println(avl);

        avl.remove(52);

        BinaryTrees.println(avl);
    }


}