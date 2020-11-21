package com.tatumalenko.algorithms.kotlin.leetcode

object MaxConsecutiveOnes485 {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var max = 0
        var count = 0
        for (n in nums) {
            when (n) {
                1 -> {
                    count++
                }
                else -> {
                    max = maxOf(max, count)
                    count = 0
                }
            }
        }
        return maxOf(max, count)
    }
}
