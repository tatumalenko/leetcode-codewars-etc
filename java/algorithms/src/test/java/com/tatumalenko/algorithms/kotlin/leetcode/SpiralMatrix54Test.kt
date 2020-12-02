package com.tatumalenko.algorithms.kotlin.leetcode

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class SpiralMatrix54Test {

    companion object {
        @JvmStatic
        fun arguments(): Stream<Arguments> = Stream.of(
            Arguments.of(arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(4, 5, 6),
                intArrayOf(7, 8, 9)), listOf(1, 2, 3, 6, 9, 8, 7, 4, 5)),
            Arguments.of(arrayOf(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(5, 6, 7, 8),
                intArrayOf(9, 10, 11, 12)), listOf(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7))
        )
    }

    @ParameterizedTest
    @MethodSource("arguments")
    fun spiralOrder(matrix: Array<IntArray>, expected: List<Int>) {
        assertEquals(expected, SpiralMatrix54.spiralOrder(matrix))
    }
}
