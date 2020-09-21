package com.tatumalenko.algorithms.kotlin.leetcode

import com.tatumalenko.algorithms.kotlin.ds.TreeNode

object InvertBinaryTree226 {
    fun invertTree(root: TreeNode?): TreeNode? {
        return copy(root)
    }

    fun copy(original: TreeNode?): TreeNode? {
        var new: TreeNode? = null
        original?.let {
            new = TreeNode(it.`val`)
            new?.left = copy(it.right)
            new?.right = copy(it.left)
        }
        return new
    }
}