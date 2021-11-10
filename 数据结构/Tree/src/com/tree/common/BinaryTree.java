package com.tree.common;

import com.printer.BinaryTreeInfo;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E> implements BinaryTreeInfo {
    protected int size;

    public Node<E> root;

    /**
     * 返回元素个数
     *
     * @return
     */
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 清空元素
     */
    public void clear() {
        root = null;
        size = 0;
    }

    protected static class Node<E> {
        public E element;
        public Node<E> left;
        public Node<E> right;
        public Node<E> parent;
        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        public boolean isLeftChild() {
            return parent != null && this == parent.left;
        }

        public boolean isRightChild() {
            return parent != null && this == parent.right;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public boolean hasTwoChildren() {
            return left != null && right != null;
        }
    }


    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element not be null");
        }
    }

    protected Node<E> createNode(E element, Node<E> parent) {
        return new Node<>(element, parent);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(root, sb, "");
        return sb.toString();
    }

    private void toString(Node<E> node, StringBuilder sb, String prefix) {
        if (node == null) return;

        toString(node.left, sb, prefix + "L---");
        sb.append(prefix).append(node.element).append("\n");
        toString(node.right, sb, prefix + "R---");
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>) node).left;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object right(Object node) {
        return ((Node<E>) node).right;
    }

    @Override
    public Object string(Object node) {
        Node<E> myNode = (Node<E>) node;
        String parentString = "null";
        if (myNode.parent != null) {
            parentString = myNode.parent.element.toString();
        }
        return myNode.element + "_p(" + parentString + ")";
    }
    /**
     * 遍历二叉树
     * ------ 递归遍历方式------
     */
    /**
     * 前序遍历
     */
    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    private void preOrderTraversal(Node<E> node) {
        if (node == null) return;

        System.out.println(node.element);

        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    /**
     * 中序遍历
     */
    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node<E> node) {

        if (node == null) return;

        inOrderTraversal(node.left);
        System.out.println(node.element);
        inOrderTraversal(node.right);

    }

    /**
     * 后序遍历
     */
    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    private void postOrderTraversal(Node<E> node) {
        if (node == null) return;

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.println(node.element);
    }

    /**
     * 层次遍历
     */
    public void levelOrerTraversal() {
        if (root == null) return;


        Queue<Node<E>> queue = new LinkedList<>();


        queue.offer(root);

        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();//先将root 入队列

            System.out.println(node.element);

            if (node.left != null) {
                queue.offer(node.left);// 先将左节点入队列
            }
            if (node.right != null) {
                queue.offer(node.right);//将右节点入队列
            }
        }
    }

    /**
     * 前序遍历&&反转二叉树
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node<E> node) {
        if (node == null) return;
        Node<E> temp = node.left;
        node.left = node.right;
        node.right = temp;
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node<E> node) {
        if (node == null) return;

        inOrder(node.left);
        Node<E> temp = node.left;
        node.left = node.right;
        node.right = temp;
        inOrder(node.left);

    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node<E> node) {
        if (node == null) return;

        inOrder(node.left);
        inOrder(node.right);
        Node<E> temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    /**
     * 使用层序遍历反转二叉树的值
     */
    public void levelOrder() {
        if (root == null) return;
        Queue<Node<E>> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            Node<E> node = queue.poll();

            Node<E> temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }

        }
    }


    /**
     * 获取前驱节点
     *
     * @return
     */
    public Node<E> getPre(Node<E> node) {
        if (node == null) return null;


        Node<E> p = node.left;
        if (p != null) {
            // 通过查找node的left的right----right进行查找，直到获取到node.right==null时
            while (node.right != null) {
                p = p.right;
            }
            return p;
        }
        //通过parent进行向上查找
        while (node.parent != null && node.parent.left == node) {
            node = node.parent;
        }
        return node.parent;
    }

    /**
     * 获取后继节点
     *
     * @return
     */
    public Node<E> getSuccessor(Node<E> node) {
        if (node == null) return null;


        Node<E> p = node.right;
        if (p != null) {
            // 通过查找node的left的right----right进行查找，直到获取到node.right==null时
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }
        //通过parent进行向上查找
        while (node.parent != null && node.parent.right == node) {
            node = node.parent;
        }
        return node.parent;
    }

    /**
     * 递归获取树的高度
     */
    public int height() {
        return height(root);
    }

    private int height(Node<E> node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }


    public int useLevelGetHeight() {
        if (root == null) return 0;

        int height = 0;
        Queue<Node<E>> queue = new LinkedList<>();

        queue.offer(root);
        int levelSize = 1;
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            levelSize--;

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }

            if (levelSize == 0) {//每次队列中size 为0时代表当前层为空 更新高度以及更新levelSize的个数
                levelSize = queue.size();
                height++;
            }
        }

        return height;
    }

    /**
     * 判断是否为完全二叉树
     *
     * @return
     */
    public boolean isComplete() {
        /**
         * 思路：
         * full binary tree = 右子节点为最后一个节点
         *
         * 通过队列判定最后一个出队的节点是左字节点还是右子节点，如果为右子节点则为完全二叉树
         */

        if (root == null) return false;

        Queue<Node<E>> queue = new LinkedList<>();

        queue.offer(root);
        boolean leaf = false;

        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            if (leaf && !node.isLeaf()) return false;
            if (node.left != null && node.right != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            } else if (node.left == null && node.right != null) {
                return false;
            } else {
                leaf = true;
                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
        }
        return true;
    }
}
