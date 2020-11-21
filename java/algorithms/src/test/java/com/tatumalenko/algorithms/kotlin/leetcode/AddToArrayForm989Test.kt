package com.tatumalenko.algorithms.kotlin.leetcode

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class AddToArrayForm989Test {
    companion object {
        @JvmStatic
        fun arguments(): Stream<Arguments> = Stream.of(
            Arguments.of(intArrayOf(1, 2, 0, 0), 34, listOf(1, 2, 3, 4)),
            Arguments.of(intArrayOf(2, 7, 4), 181, listOf(4, 5, 5)),
            Arguments.of(intArrayOf(9, 9, 9, 9, 9, 9, 9, 9, 9, 9), 1, listOf(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0))
        )
    }

    @ParameterizedTest(name = "{index} ==> given {0} and {1} should return {2}")
    @MethodSource("arguments")
    fun test(A: IntArray, K: Int, expected: List<Int>) {
        assertEquals(expected, AddToArrayForm989.addToArrayForm(A, K))
    }
}
