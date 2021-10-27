package com.tree;

import com.printer.BinaryTreeInfo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("ALL")
public class BinarySearchTree<E> implements BinaryTreeInfo {

    int size;

    Node<E> root;
    private Comparator<E> comparator;

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

    /**
     * 添加元素
     *
     * @param element
     */
    public void add(E element) {
        elementNotNullCheck(element);
        if (root == null) {
            root = new Node<>(null, element);
            size++;
            return;
        }

        // 添加的不是第一个节点root时

        Node<E> parent = root;
        Node<E> node = this.root;

        int cmp = 0;

        do {
            cmp = compare(element, node.element);
            parent = node;// 保存其父节点

            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else {
                node.element = element;
                return;
            }
        } while (node != null);

        Node<E> newNode = new Node<>(parent, element);//找到最后的父节点后进行节点的构建

        if (cmp > 0) {//判断节点应处于左还是右
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;
    }

    /**
     * 删除元素
     *
     * @param element
     */
    public void remove(E element) {

        Node<E> node = node(element);
        remove(node);

    }

    private void remove(Node<E> node) {
        if (node == null) return;


        if (node.hasTwoChilden()) {
            // node是叶子节点
            Node<E> s = getSuccessor(node);

            node.element = s.element;
            node = s;
        }

        Node<E> replacement = node.left != null ? node.left : node.right;
        if (replacement != null) {
            //要删除的节点度为1
            replacement.parent = node.parent;
            if (node.parent == null) {
                root = replacement;//删除的节点度为1
            } else if (node == node.parent.left) {//node是左节点
                node.parent.left = replacement;
            } else { // node == node.parent.right
                node.parent.right = replacement;
            }
        } else if (node.parent == null) {
            // 删除的是根节点
            root = null;
        } else {
            // node是叶子节点
            if (node == node.parent.left) {
                node.parent.left = null;
            } else { // node == node.parent.right
                node.parent.right = null;
            }
        }
    }

    /**
     * 查看是否包含某个元素
     *
     * @param element
     * @return
     */
    public boolean contains(E element) {
        return node(element) != null;
    }

    private static class Node<E> {
        E element;

        Node<E> right;
        Node<E> left;
        Node<E> parent;


        public Node(Node<E> parent, E element) {
            this.parent = parent;
            this.element = element;
        }


        /**
         * 判定节点是否为叶子节点
         *
         * @return
         */
        public boolean isLeaf() {
            return left == null && right == null;
        }

        public boolean hasTwoChilden() {
            return left != null && right != null;
        }
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element not be null");
        }
    }

    /**
     * @return 返回值等于0，代表e1和e2相等；返回值大于0，代表e1大于e2；返回值小于于0，代表e1小于e2
     */
    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        return ((Comparable<E>) e1).compareTo(e2);
    }

    private Node<E> node(E element) {
        Node<E> node = root;
        while (node != null) {
            int cmp = compare(element, node.element);
            if (cmp == 0) return node;
            if (cmp > 0) {
                node = node.right;
            } else { // cmp < 0
                node = node.left;
            }
        }
        return null;
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
            while (node.left != null) {
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
