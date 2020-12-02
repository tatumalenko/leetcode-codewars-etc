package com.tatumalenko.algorithms.kotlin.leetcode

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class SearchSuggestionsSystem1268Test {

    companion object {
        @JvmStatic
        fun arguments(): Stream<Arguments> = Stream.of(
            Arguments.of(
                arrayOf("mobile", "mouse", "moneypot", "monitor", "mousepad"),
                "mouse",
                listOf(listOf("mobile", "moneypot", "monitor"),
                    listOf("mobile", "moneypot", "monitor"),
                    listOf("mouse", "mousepad"),
                    listOf("mouse", "mousepad"),
                    listOf("mouse", "mousepad")))
        )
    }

    @ParameterizedTest(name = "{index} ==> given {0}, {1} should return {2}")
    @MethodSource("arguments")
    fun suggestedProducts(products: Array<String>, word: String, expected: List<List<String>>) {
        assertEquals(expected, SearchSuggestionsSystem1268.suggestedProducts(products, word))
    }
}
