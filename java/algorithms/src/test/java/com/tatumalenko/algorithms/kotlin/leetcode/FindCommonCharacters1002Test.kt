package com.tatumalenko.algorithms.kotlin.leetcode

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class FindCommonCharacters1002Test {

    companion object {
        @JvmStatic
        fun arguments(): Stream<Arguments> = Stream.of(
//            Arguments.of(arrayOf("bella", "label", "roller"), listOf("e", "l", "l")),
            Arguments.of(arrayOf("acabcddd", "bcbdbcbd", "baddbadb", "cbdddcac", "aacbcccd", "ccccddda", "cababaab", "addcaccd"), emptyList<String>())
        )
    }

    @ParameterizedTest(name = "{index} ==> given {0} should return {1}")
    @MethodSource("arguments")
    fun commonChars(input: Array<String>, expected: List<String>) {
        assertEquals(expected, FindCommonCharacters1002.commonChars(input))
    }
}
