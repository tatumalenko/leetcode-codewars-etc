package com.tatumalenko.algorithms.kotlin.leetcode

import org.junit.jupiter.api.Test

internal class LetterCombinations17Test {
    @Test
    fun letterCombinations() {
        val actual = LetterCombinations17.letterCombinations("23")
        val expected = listOf("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")
        assert(actual == expected)
    }

    @Test
    fun `when empty string, returns empty list`() {
        val actual = LetterCombinations17.letterCombinations("")
        val expected = emptyList<String>()
        assert(actual == expected)
    }

}