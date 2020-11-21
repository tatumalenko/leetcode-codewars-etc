package com.tatumalenko.algorithms.kotlin.leetcode

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class MaxSubArray53Test {
    companion object {
        @JvmStatic
        fun arguments(): Stream<Arguments> = Stream.of(
            Arguments.of(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4), 6),
            Arguments.of(intArrayOf(1, 2), 3)
        )
    }

    @ParameterizedTest(name = "{index} ==> given {0} should return {1}")
    @MethodSource("arguments")
    fun test(input: IntArray, expected: Int) {
        assertEquals(expected, MaxSubArray53.maxSubArray(input))
    }
}
