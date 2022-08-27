package org.vishal1297.ds.chapter_4.impl;

import java.util.ArrayList;

public class TreeImpl<T extends Comparable<T>> {

    private TreeNode<T> root;

    public TreeImpl(TreeNode<T> root) {
        this.root = root;
    }

    public TreeImpl(T key) {
        this.root = new TreeNode<T>(key);
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean exists(T key) {
        return find(this.root, key);
    }

    public TreeNode<T> isNodeExists(T key) {
        return findNode(this.root, key);
    }

    public void clear() {
        setRoot(null);
    }

    public boolean find(TreeNode<T> node, T key) {
        if (node.getData().equals(key)) return true;
        boolean found = false;
        for (TreeNode<T> child : node.getChildrens()) {
            if (find(child, key)){
                found = true;
                break;
            }
        }
        return found;
    }

    public TreeNode<T> findNode(TreeNode<T> node, T key) {
        if (node.getData().equals(key)) return node;
        for (TreeNode<T> child : node.getChildrens()) {
            if (findNode(child, key) != null) {
                return child;
            }
        }
        return null;
    }

    public int getSize() {
        return getNumberOfDescendants(this.root) + 1;
    }

    public int getNumberOfDescendants(TreeNode<T> node) {
        int n = node.getChildrens().size();
        for (TreeNode<T> child : node.getChildrens()) {
            n += getNumberOfDescendants(child);
        }
        return n;
    }

    public ArrayList<TreeNode<T>> getPreOrderTraversal() {
        ArrayList<TreeNode<T>> preOrder = new ArrayList<>();
        return buildPreOrder(this.root, preOrder);
    }

    public ArrayList<TreeNode<T>> buildPreOrder(TreeNode<T> node, ArrayList<TreeNode<T>> preOrder) {
        preOrder.add(node);
        for (TreeNode<T> child : node.getChildrens()) {
            buildPreOrder(child, preOrder);
        }
        return preOrder;
    }

    public ArrayList<TreeNode<T>> getPostOrderTraversal() {
        ArrayList<TreeNode<T>> postOrder = new ArrayList<>();
        return buildPostOrder(this.root, postOrder);
    }

    public ArrayList<TreeNode<T>> buildPostOrder(TreeNode<T> node, ArrayList<TreeNode<T>> postOrder) {
        for (TreeNode<T> child : node.getChildrens()) {
            buildPostOrder(child, postOrder);
        }
        postOrder.add(node);
        return postOrder;
    }

    public void preOrder() {
        System.out.println("Pre order : ");
        for (TreeNode<T> node : getPreOrderTraversal()) {
            System.out.print(node.getData() + " ");
        }
        System.out.println();
    }

    public void postOrder() {
        System.out.println("Post order : ");
        for (TreeNode<T> node : getPostOrderTraversal()) {
            System.out.print(node.getData() + " ");
        }
        System.out.println();
    }

    public int getHeight() {
        ArrayList<TreeNode<T>> longestPath = getLongestPathFromRootToAnyLeaf();
        return longestPath == null ? 0 : longestPath.size();
    }

    public ArrayList<TreeNode<T>> getLongestPathFromRootToAnyLeaf() {
        ArrayList<TreeNode<T>> longest = null;
        int max = 0;
        for (ArrayList<TreeNode<T>> path : getPathsFromRootToAnyLeaf()) {
            if (path.size() > max) {
                max = path.size();
                longest = path;
            }
        }
        return longest;
    }

    public ArrayList<ArrayList<TreeNode<T>>> getPathsFromRootToAnyLeaf() {
        ArrayList<ArrayList<TreeNode<T>>> paths = new ArrayList<>();
        ArrayList<TreeNode<T>> current = new ArrayList<>();
        return getPath(this.root, current, paths);
    }

    public ArrayList<ArrayList<TreeNode<T>>> getPath(
            TreeNode<T> node,
            ArrayList<TreeNode<T>> currentPath,
            ArrayList<ArrayList<TreeNode<T>>> paths
    ) {
        if (node == null || currentPath == null) {
            return paths;
        }

        currentPath.add(node);

        if (node.getChildrens().size() == 0) {
            paths.add(clone(currentPath));
        }

        for (TreeNode<T> child : node.getChildrens()) {
            getPath(child, currentPath, paths);
        }

        int indexOfLeaf = currentPath.indexOf(node);
        if (currentPath.size() > indexOfLeaf) {
            currentPath.subList(indexOfLeaf, currentPath.size()).clear();
        }

        return paths;
    }

    public ArrayList<TreeNode<T>> clone(ArrayList<TreeNode<T>> list) {
        ArrayList<TreeNode<T>> cloned = new ArrayList<>();
        for (TreeNode<T> child : list) {
            cloned.add(new TreeNode<>(child.getData()));
        }
        return cloned;
    }

    public static void main(String[] args) {
        TreeImpl<Integer> tree = new TreeImpl<>(888);
        TreeNode<Integer> root = tree.getRoot();

        TreeNode<Integer> first = new TreeNode<>(2);
        TreeNode<Integer> second = new TreeNode<>(5);

        root.addChild(first);
        root.addChild(second);

        root.addChild(new TreeNode<>(3));
        first.addChild(new TreeNode<>(8));
        first.addChild(new TreeNode<>(9));

        Integer key = 7;

        System.out.println("Height : " + tree.getHeight());
        System.out.println("Size : " + tree.getSize());

        System.out.println(key + (tree.exists(key) ? " Exists" : " Not Exists"));

        System.out.println(key + (tree.isNodeExists(key) != null ? " Node Exists" : " Node Not Exists"));

        System.out.println("Root Descendants : " + tree.getNumberOfDescendants(root));

        System.out.println("Longest path : " + tree.getLongestPathFromRootToAnyLeaf());

        tree.preOrder();

        tree.postOrder();
    }

    static class TreeNode<T extends Comparable<T>> {
        private T data;
        private ArrayList<TreeNode<T>> childrens;

        private TreeNode<T> parent;

        public TreeNode() {
        }

        public TreeNode(T data) {
            this.data = data;
            this.childrens = new ArrayList<>();
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public ArrayList<TreeNode<T>> getChildrens() {
            return childrens;
        }

        public void setChildrens(ArrayList<TreeNode<T>> childrens) {
            this.childrens = childrens;
        }

        public void setParent(TreeNode<T> parent) {
            this.parent = parent;
        }

        public TreeNode<T> getParent() {
            return parent;
        }

        public void addChild(TreeNode<T> child) {
            child.parent = this;
            this.childrens.add(child);
        }

        public void addChildAt(int index, TreeNode<T> child) {
            child.parent = this;
            this.childrens.add(index, child);
        }

        public void removeAllChilds() {
            this.childrens.clear();
        }

        public boolean removeChild(TreeNode<T> child) {
            return getChildrens().remove(child);
        }

        public TreeNode<T> removeChildAt(int index) {
            return getChildrens().remove(index);
        }

        public TreeNode<T> getChildAt(int index) {
            return this.childrens.get(index);
        }

        @Override
        public boolean equals(Object obj) {
            if (null == obj)
                return false;
            if (obj instanceof TreeNode<?>) {
                return ((TreeNode<?>) obj).getData().equals(this.getData());
            }
            return false;
        }

        @Override
        public String toString() {
            return this.data.toString();
        }

    }

}