package com.tatumalenko.algorithms.kotlin.leetcode

object MoveZeroes283 {
    fun moveZeroes(nums: IntArray): Unit {
        var i = 0
        var zeroCount = 0
        while (i < nums.size) {
            if (nums[i] == 0) {
                zeroCount++
                for (j in i until nums.size - 1) {
                    nums[j] = nums[j + 1]
                }
            }
            i++
        }
        for (i in (0 until nums.size).reversed()) {
            if (zeroCount > 0) {
                nums[i] = 0
                zeroCount--
            } else {
                break
            }
        }
    }
}
