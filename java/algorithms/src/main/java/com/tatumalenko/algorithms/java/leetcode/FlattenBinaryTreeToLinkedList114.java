package com.tatumalenko.algorithms.java.leetcode;

import com.tatumalenko.algorithms.java.datastructures.BinaryTreeNode;

public class FlattenBinaryTreeToLinkedList114 {

    public TreeNode flatten(final TreeNode root) {
        return flattenIterative(root);
    }

    private TreeNode flattenIterative(final TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode last = (TreeNode) cur.left;
                while (last.right != null) {
                    last = (TreeNode) last.right;
                }
                last.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = (TreeNode) cur.right;
        }
        return root;
    }

    private TreeNode flattenRecursive(final TreeNode root) {
        if (root == null) {
            return null;
        }
        // flattenHelper(root);
        return flattenHelper(root);
    }

    private TreeNode flattenHelper(final TreeNode node) {
        if (node == null) {
            return null;
        }
        final TreeNode left = flattenHelper((TreeNode) node.left);
        final TreeNode right = flattenHelper((TreeNode) node.right);
        node.left = null;
        node.right = left;
        TreeNode temp = node;
        while (temp.right != null) {
            temp = (TreeNode) temp.right;
        }
        temp.right = right;
        return node;
    }

    static class TreeNode extends BinaryTreeNode<Integer> {

        TreeNode(final Integer val) {
            super(val);
        }

        TreeNode(final Integer val, final TreeNode left, final TreeNode right) {
            super(val, left, right);
        }

    }

}
