package com.tatumalenko.algorithms.kotlin.leetcode

object FindCommonCharacters1002 {
    fun commonChars(A: Array<String>): List<String> {
        var result = A.firstOrNull()?.toCharArray()?.toSet()
        for (strings in A.drop(1)) {
            val chars = strings.toCharArray().toMutableSet()
            result = result?.intersect(chars)
            // TODO make the counting of occurences here
            //for (c in result ?: emptySet()) {
            //}
        }
        val result2 = mutableListOf<Char>()
        for (c in result ?: emptySet()) {
            var count = 0
            for (strings in A) {
                val currentCount = strings.toCharArray().count { it == c }
                count = if (count != 0) minOf(count, currentCount) else currentCount
            }
            for (i in 0 until count) {
                result2.add(c)
            }
        }

        return result2.map { it.toString() }
    }
}
