package com.tatumalenko.algorithms.kotlin.leetcode

import com.tatumalenko.algorithms.kotlin.ds.TreeNode

object FlattenBinaryTreeToLinkedList114 {
    fun flatten(root: TreeNode?): Unit {
        flattenRightIterative(root)
    }

    private fun flattenRightIterative(tip: TreeNode?): Unit {
        var current = tip

        while (current != null) {
            current.left?.let { left ->
                val rightest = findLowestRightNode(left)
                rightest.right = current?.right
                current?.right = current?.left
                current?.left = null
            }
            current = current.right
        }
        
    }

    private fun flattenLeftRecursive(tip: TreeNode?): Unit {
        tip?.let { node ->
            node.left?.let { flattenLeftRecursive(it) }

            node.right?.let { flattenLeftRecursive(it) }

            node.right?.let {
                val leftest = findLowestLeftNode(node)
                leftest.left = node.right
                node.right = null
            }
        }
    }

    private fun flattenRightRecursive(tip: TreeNode?): Unit {
        tip?.let { node ->
            node.left?.let { flattenRightRecursive(it) }

            node.right?.let { flattenRightRecursive(it) }

            node.left?.let {
                val newNodeRight = it
                val rightest = findLowestRightNode(newNodeRight)
                rightest.right = node.right
                node.right = newNodeRight
                node.left = null
            }
        }
    }

    private fun findLowestLeftNode(node: TreeNode): TreeNode {
        var current: TreeNode? = node
        while (current?.left != null) {
            current = current.left
        }
        return current ?: node
    }

    private fun findLowestRightNode(node: TreeNode): TreeNode {
        var current: TreeNode? = node
        while (current?.right != null) {
            current = current.right
        }
        return current ?: node
    }

    fun <E> MutableList<E>.pop(): E? {
        return if (this.count() > 0) this.removeAt(this.count() - 1) else null
    }
}