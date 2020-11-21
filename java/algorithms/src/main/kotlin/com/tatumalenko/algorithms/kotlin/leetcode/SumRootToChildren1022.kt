package com.tatumalenko.algorithms.kotlin.leetcode

import com.tatumalenko.algorithms.kotlin.ds.TreeNode
import kotlin.math.pow

object SumRootToChildren1022 {
    fun sumRootToLeaf(root: TreeNode?): Int {
        val stack = ArrayDeque<TreeNode?>()
        val map = HashMap<TreeNode?, TreeNode?>()
        var sum = 0
        stack.addLast(root)
        map[root] = null

        while (stack.isNotEmpty()) {
            val current = stack.removeLastOrNull()

            if (current?.left == null && current?.right == null) {
                sum += current?.binarySum(map) ?: 0
            }

            if (current?.right != null) {
                map[current.right] = current
                stack.addLast(current.right)
            }

            if (current?.left != null) {
                map[current.left] = current
                stack.addLast(current.left)
            }
        }

        return sum
    }

    fun TreeNode.binarySum(map: HashMap<TreeNode?, TreeNode?>): Int {
        val stack = ArrayDeque<TreeNode>()
        var current: TreeNode? = this
        while (current != null) {
            stack.addLast(current)
            current = map[current]
        }

        return stack.binarySum()
    }

    fun ArrayDeque<TreeNode>.binarySum(): Int {
        var decimalValue = 0
        for (i in this.indices) {
            decimalValue += this.toList()[i].`val` * 2.0.pow(i.toDouble()).toInt()
        }
        return decimalValue
    }
}
