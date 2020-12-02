package com.tatumalenko.algorithms.kotlin.leetcode

object MaximumNumberVowelsSubstringGivenLength1456 {
    fun maxVowels(s: String, k: Int): Int {
        var max = 0
        var count = 0
        var left = 0
        var right = 0
        while (right < s.length) {
            val c = s[right]
            if (c.isVowel() && right - left >= k) {
                val leftIsVowel = if (s[left].isVowel()) 0 else 1
                count += leftIsVowel
                max = maxOf(max, count)
                left++
            } else if (c.isVowel()) {
                count++
                max = maxOf(max, count)
            } else if (right - left >= k) {
                val leftIsVowel = if (s[left].isVowel()) -1 else 0
                count += leftIsVowel
                max = maxOf(max, count)
                left++
            }
            right++
        }
        return max
    }

    fun Char.isVowel(): Boolean {
        return when (this) {
            'a', 'e', 'i', 'o', 'u' -> true
            else -> false
        }
    }
}
