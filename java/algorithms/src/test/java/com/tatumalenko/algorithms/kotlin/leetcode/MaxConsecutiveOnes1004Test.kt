package com.tatumalenko.algorithms.kotlin.leetcode

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class MaxConsecutiveOnes1004Test {
    companion object {
        @JvmStatic
        fun arguments(): Stream<Arguments> = Stream.of(
            Arguments.of(intArrayOf(1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0), 2, 6),
            Arguments.of(intArrayOf(0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1), 3, 10),
            Arguments.of(intArrayOf(0, 0, 0), 3, 3),
            Arguments.of(intArrayOf(0, 0, 0, 1, 0), 3, 4),
            Arguments.of(intArrayOf(0, 0, 1, 1, 1, 0, 0), 0, 3),
            Arguments.of(intArrayOf(1, 1, 1, 0, 0, 0, 1, 1, 1, 1), 0, 4),
            Arguments.of(intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 0), 1, 9),
            Arguments.of(intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 0), 0, 8),
            Arguments.of(intArrayOf(1, 1, 0, 1, 1, 1, 1, 1, 0), 0, 5),
            Arguments.of(intArrayOf(0, 0, 0, 0, 0, 0, 0), 0, 0),
            Arguments.of(intArrayOf(0, 0, 0, 0, 0, 0, 0), 1, 1),
            Arguments.of(intArrayOf(1, 1, 1, 1, 1, 1), 0, 6),
            Arguments.of(intArrayOf(1, 1, 1, 1, 1, 1), 6, 6)
        )
    }

    @ParameterizedTest(name = "{index} ==> given {0}, {1} should return {2}")
    @MethodSource("arguments")
    fun test(A: IntArray, K: Int, expected: Int) {
        assertEquals(expected, MaxConsecutiveOnes1004.longestOnes(A, K))
    }
}
