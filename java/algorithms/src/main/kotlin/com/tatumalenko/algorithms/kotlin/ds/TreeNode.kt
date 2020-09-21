package com.tatumalenko.algorithms.kotlin.ds

data class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null) {
    companion object {
        fun of(array: IntArray): TreeNode? {
            return insertLevelOrder(array, null, 0)
        }

        private fun insertLevelOrder(array: IntArray, root: TreeNode?, i: Int): TreeNode? {
            var node = root
            if (i < array.size) {
                val temp = TreeNode(array[i])
                node = temp
                node.left = insertLevelOrder(array, node.left, 2 * i + 1)
                node.right = insertLevelOrder(array, node.right, 2 * i + 2);
            }
            return node
        }
    }
}
