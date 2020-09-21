package com.tatumalenko.algorithms.java.datastructures;

public class BinaryTreeNode<T> implements TreeNode<T> {

    public T val;

    public TreeNode<T> left = null;

    public TreeNode<T> right = null;

    public BinaryTreeNode(final T x) {
        val = x;
    }

    public BinaryTreeNode(final T x, final TreeNode<T> left, final TreeNode<T> right) {
        val = x;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(final TreeNode<T> other) {
        if (other == null) {
            return false;
        }

        return compare(this, other);
    }

    private boolean compare(final TreeNode<T> n1, final TreeNode<T> n2) {
        if (
            (n1 == null && n2 != null)
                || (n1 != null && n2 == null)
        ) {
            return false;
        }

        if (n1 != null && n2 != null) {
            return ((BinaryTreeNode<T>) n1).val == ((BinaryTreeNode<T>) n2).val
                && compare(((BinaryTreeNode<T>) n1).left, ((BinaryTreeNode<T>) n2).left)
                && compare(((BinaryTreeNode<T>) n1).right,
                ((BinaryTreeNode<T>) n2).right);
        }
        return true;
    }

}
