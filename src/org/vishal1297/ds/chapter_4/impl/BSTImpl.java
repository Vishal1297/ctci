package org.vishal1297.ds.chapter_4.impl;

public class BSTImpl<T extends Comparable<T>> {

    private TreeNode<T> root;

    public BSTImpl() {
        super();
    }

    public BSTImpl(T data) {
        this.root = new TreeNode<T>(data);
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void insert(T data) {
        this.root = insert(this.root, data);
    }

    /**
     * Insert in binary tree
     */
    private TreeNode<T> insert(TreeNode<T> node, T data) {
        if (node == null) return new TreeNode<>(data);
        else if (data.compareTo(node.data) < 0) node.left = insert(node.left, data);
        else if (data.compareTo(node.data) > 0) node.right = insert(node.right, data);
        return node;
    }

    /**
     * Pre Order Traversal
     * <p>
     * ORDER - Left, Root, Right
     */
    public void preOrder() {
        System.out.print("Pre-order Traversal :");
        preOrder(this.root);
        System.out.println();
    }

    private void preOrder(TreeNode<T> node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * Inorder Traversal
     * <p>
     * ORDER - Root, Left, Right
     */
    public void inOrder() {
        System.out.print("In-order Traversal :");
        inOrder(this.root);
        System.out.println();
    }

    private void inOrder(TreeNode<T> node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    /**
     * Postorder Traversal
     * <p>
     * ORDER - Left, Right, Root
     */
    public void postOrder() {
        System.out.print("Post-order Traversal :");
        postOrder(this.root);
        System.out.println();
    }

    private void postOrder(TreeNode<T> node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    private T findMax(TreeNode<T> node) {
        while (node.right != null) node = node.right;
        return node.data;
    }

    public T max() {
        return findMax(this.root);
    }

    private T findMin(TreeNode<T> node) {
        while (node.left != null) node = node.left;
        return node.data;
    }

    public boolean contains(T data) {
        return contains(this.root, data);
    }

    private boolean contains(TreeNode<T> root, T data) {
        if (root == null) return false;
        else if (data.compareTo(root.data) < 0) return contains(root.left, data);
        else if (data.compareTo(root.data) > 0) return contains(root.right, data);
        else return true;
    }

    public void delete(T data) {
        this.root = delete(this.root, data);
    }

    private TreeNode<T> delete(TreeNode<T> node, T data) {
        if (node == null) return null;
        else if (data.compareTo(node.data) < 0) {
            node.left = delete(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = delete(node.right, data);
        } else {
            {
                if (node.left == null && node.right == null) {
                    return null;
                } else if (node.left == null) {
                    return node.right;
                } else if (node.right == null) {
                    return node.left;
                } else {
                    node.data = findMax(node.left);
                    node.left = delete(node.left, node.data);
                }
            }
        }
        return node;
    }

    public static void main(String[] args) {
        BSTImpl<Integer> bst = new BSTImpl<>();
        System.out.println("Binary tree operations :");
        for (int i = 0; i < 5; i++) {
            int r = (int) (Math.random() * 100) + 1;
            System.out.println("Inserting : " + r + "...");
            bst.insert(r);
        }
        System.out.println();
        if (bst.contains(74)) {
            System.out.println("Contains 74");
        }
        bst.delete(74);
        if (bst.contains(74)) {
            System.out.println("Contains 74");
        }
        bst.preOrder();
        bst.inOrder();
        bst.postOrder();

        System.out.println("Max : " + bst.findMax(bst.getRoot()));
    }

    static class TreeNode<T extends Comparable<T>> {
        private T data;
        private TreeNode<T> left;
        private TreeNode<T> right;

        public TreeNode() {
            super();
        }

        public TreeNode(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public TreeNode<T> getLeft() {
            return left;
        }

        public void setLeft(TreeNode<T> left) {
            this.left = left;
        }

        public TreeNode<T> getRight() {
            return right;
        }

        public void setRight(TreeNode<T> right) {
            this.right = right;
        }

    }
}
