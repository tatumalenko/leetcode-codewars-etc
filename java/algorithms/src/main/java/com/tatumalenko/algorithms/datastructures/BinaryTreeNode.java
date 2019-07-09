package com.tatumalenko.algorithms.datastructures;

public class BinaryTreeNode<T> implements TreeNode<T> {

    public T val;
    public TreeNode<T> left = null;
    public TreeNode<T> right = null;

    public BinaryTreeNode(T x) {
        this.val = x;
    }

    public BinaryTreeNode(T x, TreeNode<T> left, TreeNode<T> right) {
        this.val = x;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(TreeNode<T> other) {
        if (other == null) {
            return false;
        }

        return compare(this, other);
    }

    private boolean compare(TreeNode<T> n1, TreeNode<T> n2) {
        if (
                (n1 == null && n2 != null)
                        || (n1 != null && n2 == null)
        ) {
            return false;
        }

        if (n1 != null && n2 != null) {
            return ((BinaryTreeNode<T>) n1).val == ((BinaryTreeNode<T>) n2).val
                    && compare(((BinaryTreeNode<T>) n1).left, ((BinaryTreeNode<T>) n2).left)
                    && compare(((BinaryTreeNode<T>) n1).right, ((BinaryTreeNode<T>) n2).right);
        }
        return true;
    }
}
