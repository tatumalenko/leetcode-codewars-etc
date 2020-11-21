package com.tatumalenko.algorithms.kotlin.leetcode

import kotlin.math.max

object LengthOfLongestSubstring3 {
    fun lengthOfLongestSubstring(s: String): Int {
        var current = ""
        var longest = 0
        var index = 0
        while (index < s.length) {
            val c = s[index]

            if (c in current) {
                longest = max(current.length, longest)
                index = index - current.length + 1
                current = ""
            } else {
                current += c
                index++
            }
        }
        return max(current.length, longest)
    }
}
