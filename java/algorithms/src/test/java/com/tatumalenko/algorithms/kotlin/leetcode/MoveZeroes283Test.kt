package com.tatumalenko.algorithms.kotlin.leetcode

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class MoveZeroes283Test {

    companion object {
        @JvmStatic
        fun arguments(): Stream<Arguments> = Stream.of(
            Arguments.of(intArrayOf(0, 1, 0, 3, 12), intArrayOf(1, 3, 12, 0, 0))
        )
    }

    @ParameterizedTest(name = "{index} ==> given {0} should return {1}")
    @MethodSource("arguments")
    fun moveZeroes(nums: IntArray, expected: IntArray) {
        MoveZeroes283.moveZeroes(nums)
        assertEquals(expected, nums)
    }
}
