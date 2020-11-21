package com.tatumalenko.algorithms.kotlin.leetcode

object MaxSubArray53 {
    // TODO: Find O(n) soln
    fun maxSubArray(nums: IntArray): Int {
        var max = Integer.MIN_VALUE
        var current: Int
        for ((i, n) in nums.withIndex()) {
            current = 0
            max = kotlin.math.max(n, max)
            for (m in nums.slice(i until nums.size)) {
                current += m
                max = kotlin.math.max(current, max)
            }
        }
        return max
    }
}
