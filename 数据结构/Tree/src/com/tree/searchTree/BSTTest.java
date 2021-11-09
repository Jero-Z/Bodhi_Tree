package com.tree.searchTree;

import com.printer.BinaryTrees;
import com.tree.common.BinaryTree;
import org.junit.jupiter.api.Test;

class BSTTest {

    @Test
    public void testBSTAdd() {
        Integer[] data = new Integer[] {
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        BST<Integer> bst = new BST<>();
        for (Integer datum : data) {
            bst.add(datum);
        }
        BinaryTrees.println(bst);

        bst.remove(4);

        BinaryTrees.println(bst);


        bst.remove(7);
        BinaryTrees.println(bst);
    }
}