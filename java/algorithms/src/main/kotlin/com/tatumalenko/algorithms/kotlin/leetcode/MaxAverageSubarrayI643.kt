package com.tatumalenko.algorithms.kotlin.leetcode

object MaxAverageSubarrayI643 {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        var sumSoFar = 0
        for (i in 0 until k) {
            sumSoFar += nums[i]
        }
        var maxSum = sumSoFar
        for (i in k until nums.size) {
            sumSoFar += nums[i] - nums[i - k]
            maxSum = maxOf(maxSum, sumSoFar)
        }

        return maxSum.toDouble() / k
    }
}
