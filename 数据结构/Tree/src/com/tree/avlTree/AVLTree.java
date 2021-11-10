package com.tree.avlTree;

import com.tree.bst.BST;

import java.util.Comparator;

public class AVLTree<E> extends BST<E> {

    public AVLTree() {
        this(null);
    }

    public AVLTree(Comparator<E> comparator) {
        super(comparator);
    }


    @Override
    protected void afterAdd(Node<E> node) {
        while ((node = node.parent) != null) {
            if (isBalanced(node)) {
                updateHeight(node);
            } else {
                reBalance(node);
                break;
            }
        }
    }

    private void reBalance(Node<E> grandNode) {
        Node<E> parent = ((AVLNode<E>) grandNode).tallerChild();
        Node<E> node = ((AVLNode<E>) parent).tallerChild();
        if (parent.isLeftChild()) {//L
            if (node.isLeftChild()) {//LL
                rotateRight(grandNode);
            } else {//LR
                rotateLeft(parent);
                rotateRight(grandNode);
            }
        } else {//R
            if (node.isLeftChild()) {//RL
                rotateRight(parent);
                rotateLeft(grandNode);
            } else {//RR
                rotateLeft(grandNode);
            }
        }
    }

    /**
     * 左旋
     *
     * @param grand
     */
    private void rotateLeft(Node<E> grand) {
        Node<E> parent = grand.right;//当前节点的右节点成为父节点
        Node<E> child = parent.left;
        grand.right = child;
        parent.left = grand;
        //当前节点成为右节点的左子节点

        afterRotate(grand, parent, child);
    }

    /**
     * 右旋
     *
     * @param grand
     */
    private void rotateRight(Node<E> grand) {
        Node<E> parent = grand.left;

        Node<E> child = parent.right;

        grand.left = child;

        parent.right = grand;

        afterRotate(grand, parent, child);
    }

    /**
     * 旋转后需要共同维护的指针
     *
     * @param grand
     * @param node
     * @param child
     */
    private void afterRotate(Node<E> grand, Node<E> node, Node<E> child) {
        /*
        调整后需要更新grand的parent
        newParent的parent = grand parent
        grand parent 的子节点更新为new parent
         更新child 的parent
         维护grand的高度
         维护new parent（node）的高度
         */
        node.parent = grand.parent;

        if (grand.isLeftChild()) {//更新grand的parent 的child的指向-> new node
            grand.parent.left = node;
        } else if (grand.isRightChild()) {
            grand.parent.right = node;
        } else {
            root = node;
        }

        if (child != null) {
            child.parent = grand;
        }

        grand.parent = node;


        updateHeight(grand);
        updateHeight(node);
    }

    @Override
    protected Node<E> createNode(E element, Node<E> parent) {
        return new AVLNode<>(element, parent);
    }

    @Override
    public void afterRemove(Node<E> node) {
        while ((node = node.parent) != null) {
            if (isBalanced(node)) {
                updateHeight(node);
            } else {
                reBalance(node);
            }
        }
    }

    public boolean contains() {
        return false;
    }

    private Node<E> node(E element) {
        return null;
    }

    private static class AVLNode<E> extends Node<E> {
        int height = 1;

        public AVLNode(E element, Node<E> parent) {
            super(element, parent);
        }

        public int balanceFactor() {
            int leftHeight = left == null ? 0 : ((AVLNode<E>) left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>) right).height;
            return leftHeight - rightHeight;
        }

        public void updateHeight() {
            int leftHeight = left == null ? 0 : ((AVLNode<E>) left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>) right).height;
            height = 1 + Math.max(leftHeight, rightHeight);
        }

        public Node<E> tallerChild() {
            int leftHeight = left == null ? 0 : ((AVLNode<E>) left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>) right).height;
            if (leftHeight > rightHeight) return left;
            if (leftHeight < rightHeight) return right;
            return isLeftChild() ? left : right;
        }

        @Override
        public String toString() {
            String parentString = "null";
            if (parent != null) {
                parentString = parent.element.toString();
            }
            return element + "_p(" + parentString + ")_h(" + height + ")";
        }
    }

    private boolean isBalanced(Node<E> node) {
        return Math.abs(((AVLNode<E>) node).balanceFactor()) <= 1;
    }

    private void updateHeight(Node<E> node) {
        ((AVLNode<E>) node).updateHeight();
    }

}
