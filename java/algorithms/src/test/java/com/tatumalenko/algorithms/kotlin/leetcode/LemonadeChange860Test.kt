package com.tatumalenko.algorithms.kotlin.leetcode

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class LemonadeChange860Test {

    companion object {
        @JvmStatic
        fun arguments(): Stream<Arguments> = Stream.of(
            Arguments.of(intArrayOf(5, 5, 5, 5, 20, 20, 5, 5, 20, 5), false),
            Arguments.of(intArrayOf(5, 5, 10), true),
            Arguments.of(intArrayOf(10, 10), false),
            Arguments.of(intArrayOf(5, 5, 10, 10, 20), false)
        )
    }

    @ParameterizedTest(name = "{index} ==> given {0} should return {1}")
    @MethodSource("arguments")
    fun test(input: IntArray, expected: Boolean) {
        assertEquals(LemonadeChange860.lemonadeChange(input), expected)
    }

}
