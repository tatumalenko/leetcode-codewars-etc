package com.tatumalenko.algorithms.kotlin.leetcode

import com.tatumalenko.algorithms.kotlin.ds.TreeNode
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class SumRootToChildren1022Test {
    companion object {
        @JvmStatic
        fun arguments(): Stream<Arguments> = Stream.of(
            Arguments.of(TreeNode.of(intArrayOf(1, 0, 1, 0, 1, 0, 1)), 22)
        )
    }

    @ParameterizedTest(name = "{index} ==> given {0} should return {1}")
    @MethodSource("arguments")
    fun test(input: TreeNode?, expected: Int) {
        assertEquals(expected, SumRootToChildren1022.sumRootToLeaf(input))
    }
}
