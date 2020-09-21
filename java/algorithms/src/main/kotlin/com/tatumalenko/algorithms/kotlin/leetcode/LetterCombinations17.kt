package com.tatumalenko.algorithms.kotlin.leetcode

object LetterCombinations17 {
    val map = mapOf(
            "2" to "abc",
            "3" to "def",
            "4" to "ghi",
            "5" to "jkl",
            "6" to "mno",
            "7" to "pqrs",
            "8" to "tuv",
            "9" to "wxyz"
    )

    fun letterCombinations(digits: String): List<String> {
        if (digits == "") return listOf()
        val results = mutableListOf<String>()
        backtrack(results, "", digits)
        return results
    }

    fun backtrack(results: MutableList<String>, combination: String, nextDigits: String) {
        if (nextDigits.isEmpty()) {
            results.add(combination)
            return
        }

        val nextDigit = nextDigits.substring(0, 1)
        val nextCharacters = map[nextDigit]

        nextCharacters?.let {
            for (i in 0 until it.count()) {
                val suffix = it.substring(i, i + 1)
                backtrack(results, combination + suffix, nextDigits.substring(1, nextDigits.count()))
            }
        }
    }
}