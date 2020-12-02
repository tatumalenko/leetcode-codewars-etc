package com.tatumalenko.algorithms.kotlin.ds

data class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null) {
    companion object {
        fun of(vararg array: Int): TreeNode? {
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

    fun inOrder(): List<Int> {
        val inOrderNodes = mutableListOf<Int?>()
        val queue = ArrayDeque<TreeNode>()
        var current: TreeNode? = this

        while (current != null || queue.isNotEmpty()) {
            while (current != null) {
                queue.addLast(current)
                current = current.left
            }
            current = queue.removeLastOrNull()
            inOrderNodes.add(current?.`val`)
            current = current?.right
        }

        return inOrderNodes.filterNotNull()
    }

    fun preOrder(): List<Int> {
        val preOrderNodes = mutableListOf<Int>()
        val queue = ArrayDeque<TreeNode>()
        queue.addLast(this)

        while (queue.isNotEmpty()) {
            val current = queue.removeLastOrNull()
            current?.`val`?.let { preOrderNodes.add(it) }
            current?.right?.let { queue.addLast(it) }
            current?.left?.let { queue.addLast(it) }
        }

        return preOrderNodes
    }

    fun postOrder(): List<Int> {
        val postOrderNodes = mutableListOf<Int>()
        val queue = ArrayDeque<TreeNode>()
        var current: TreeNode? = this
        while (true) {
            while (current != null) {
                queue.addLast(current)
                queue.addLast(current)
                current = current.left
            }

            if (queue.isEmpty()) return postOrderNodes
            current = queue.removeLastOrNull()
            if (!queue.isEmpty() && queue.lastOrNull() === current) {
                current = current?.right
            } else {
                current?.let { postOrderNodes.add(it.`val`) }
                current = null
            }
        }

        return postOrderNodes
    }
}

fun main() {
    val tree = TreeNode.of(1, 2, 3, 4)
    println(tree?.inOrder())
    println(tree?.preOrder())
    println(tree?.postOrder())
}
