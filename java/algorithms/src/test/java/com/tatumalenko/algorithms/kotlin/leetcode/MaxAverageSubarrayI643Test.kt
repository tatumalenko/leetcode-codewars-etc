package com.tatumalenko.algorithms.kotlin.leetcode

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class MaxAverageSubarrayI643Test {

    companion object {
        @JvmStatic
        fun arguments(): Stream<Arguments> = Stream.of(
            Arguments.of(intArrayOf(1, 12, -5, -6, 50, 3), 4, 12.75)
        )
    }

    @ParameterizedTest(name = "{index} ==> given {0}, {1} should return {2}")
    @MethodSource("arguments")
    fun findMaxAverage(nums: IntArray, k: Int, expected: Double) {
        assertEquals(expected, MaxAverageSubarrayI643.findMaxAverage(nums, k))
    }
}
