package com.tree;


import com.printer.BinaryTrees;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

    @Test
    public void testSearchTree() {
        Integer[] data = {7, 4, 9, 8, 3, 4, 5};

        BinarySearchTree<Object> searchTree = new BinarySearchTree<>();
        for (Integer datum : data) {
            searchTree.add(datum);
        }
        System.out.println(searchTree.isComplete());
        BinaryTrees.println(searchTree);
    }

    /**
     * 反转二叉树
     */
    @Test
    public void testInvertBinaryTree() {
        Integer[] data = {7, 4, 9, 8, 3, 4, 5};

        BinarySearchTree<Object> searchTree = new BinarySearchTree<>();
        for (Integer item : data) {
            searchTree.add(item);
        }
        BinaryTrees.println(searchTree);
        /*
          前序遍历
        searchTree.preOrder();//前序遍历
        searchTree.inOrder();//中序遍历
        searchTree.postOrder();//后续遍历
         */
        searchTree.levelOrder();
        BinaryTrees.println(searchTree);
    }

    @Test
    public void testBinaryTreeRemove() {
        Integer[] data = {7, 4, 9, 8, 3, 4, 5, 12, 22};

        BinarySearchTree<Object> searchTree = new BinarySearchTree<>();
        for (Integer item : data) {
            searchTree.add(item);
        }

        BinaryTrees.println(searchTree);

        searchTree.remove(12);
        searchTree.remove(8);
        BinaryTrees.println(searchTree);
    }

}