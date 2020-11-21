package com.tatumalenko.algorithms.kotlin.leetcode

import com.tatumalenko.algorithms.kotlin.ds.TreeNode

object RangeSumBST938 {
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        return rangeSumBSTRec(root, low, high)
    }

    fun rangeSumBSTRec(root: TreeNode?, low: Int, high: Int): Int {
        val value = root?.`val` ?: 0

        return (if (value in low..high) value else 0) +
            (root?.left?.let { rangeSumBSTRec(it, low, high) } ?: 0) +
            (root?.right?.let { rangeSumBSTRec(it, low, high) } ?: 0)
    }
}
