package com.tatumalenko.algorithms.kotlin.leetcode

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class MaximumNumberVowelsSubstringGivenLength1456Test {

    companion object {
        @JvmStatic
        fun arguments(): Stream<Arguments> = Stream.of(
            Arguments.of("abciiidef", 3, 3),
            Arguments.of("aeiou", 2, 2),
            Arguments.of("leetcode", 3, 2),
            Arguments.of("rhythms", 4, 0),
            Arguments.of("tryhard", 4, 1),
            Arguments.of("a", 3, 1),
            Arguments.of("b", 3, 0),
            Arguments.of("a", 1, 1),
            Arguments.of("b", 1, 0)
        )
    }

    @ParameterizedTest(name = "{index} ==> given {0}, {1} should return {2}")
    @MethodSource("arguments")
    fun maxVowels(s: String, k: Int, expected: Int) {
        assertEquals(expected, MaximumNumberVowelsSubstringGivenLength1456.maxVowels(s, k))
    }
}
