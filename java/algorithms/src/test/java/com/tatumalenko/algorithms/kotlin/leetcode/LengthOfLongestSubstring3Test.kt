package com.tatumalenko.algorithms.kotlin.leetcode

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class LengthOfLongestSubstring3Test {
    companion object {
        @JvmStatic
        fun arguments(): Stream<Arguments> = Stream.of(
            Arguments.of("abcabcbb", 3),
            Arguments.of("pwwkew", 3),
            Arguments.of("aab", 2),
            Arguments.of("dvdf", 3),
            Arguments.of("anviaj", 5)
        )
    }

    @ParameterizedTest(name = "{index} ==> given {0} should return {1}")
    @MethodSource("arguments")
    fun test(input: String, expected: Int) {
        assertEquals(expected, LengthOfLongestSubstring3.lengthOfLongestSubstring(input))
    }
}
