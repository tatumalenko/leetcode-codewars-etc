package com.tatumalenko.algorithms.datastructures;

import java.util.ArrayList;
import java.util.List;

public interface TreeNode<T> {

    public boolean equals(TreeNode<T> other);

    public static <T> TreeNode<T> of(T[] items) {
        List<BinaryTreeNode<T>> nodes = new ArrayList<>();
        for (T item : items) {
            nodes.add(item != null ? new BinaryTreeNode<>(item) : null);
        }
        BinaryTreeNode<T> node;
        for (int i = 0; i < items.length; i++) {
            node = nodes.get(i);
            if (node != null) {
                node.left = 2 * i + 1 < nodes.size() ? nodes.get(2 * i + 1) : null;
                node.right = 2 * i + 2 < nodes.size() ? nodes.get(2 * i + 2) : null;
            }
        }
        return nodes.get(0);
    }

}
