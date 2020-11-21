package com.tatumalenko.algorithms.kotlin.leetcode

import com.tatumalenko.algorithms.kotlin.ds.TreeNode
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class InvertBinaryTree226Test {

    companion object {
        @JvmStatic
        fun arguments(): Stream<Arguments> = Stream.of(
            Arguments.of(
                TreeNode.of(intArrayOf(4, 2, 7, 1, 3, 6, 9)),
                TreeNode.of(intArrayOf(4, 7, 2, 9, 6, 3, 1))),
            Arguments.of(
                TreeNode.of(intArrayOf()),
                TreeNode.of(intArrayOf())),
            Arguments.of(
                TreeNode.of(intArrayOf(1)),
                TreeNode.of(intArrayOf(1))),
            Arguments.of(
                TreeNode.of(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)),
                TreeNode.of(intArrayOf(1, 3, 2, 7, 6, 5, 4, 15, 14, 13, 12, 11, 10, 9, 8)))
        )
    }

    @ParameterizedTest
    @MethodSource("arguments")
    fun test(input: TreeNode?, expected: TreeNode?) {
        assertEquals(expected, InvertBinaryTree226.invertTree(input))
    }

}
