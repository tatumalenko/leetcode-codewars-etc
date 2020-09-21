package com.tatumalenko.algorithms.kotlin.leetcode

import com.tatumalenko.algorithms.kotlin.ds.TreeNode
import org.junit.jupiter.api.Test

internal class FlattenBinaryTreeToLinkedList114Test {
    @Test
    fun `given binary tree, flattens to linear tree`() {
        val input = TreeNode(1,
                TreeNode(2,
                        TreeNode(3),
                        TreeNode(4)
                ),
                TreeNode(5,
                        TreeNode(6),
                        TreeNode(7)
                )
        )
        val expected = TreeNode(1,
                null,
                TreeNode(2,
                        null,
                        TreeNode(3,
                                null,
                                TreeNode(4,
                                        null,
                                        TreeNode(5,
                                                null,
                                                TreeNode(6,
                                                        null,
                                                        TreeNode(7)))))))
//        val expected =
//                TreeNode(1,
//                        TreeNode(2,
//                                TreeNode(3,
//                                        TreeNode(4, TreeNode(5, TreeNode(6, TreeNode(7)))))
//                        ))
        FlattenBinaryTreeToLinkedList114.flatten(input)

        assert(expected == input)
    }
}