package com.tatumalenko.algorithms.kotlin.leetcode

object TwoSum1 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        return twoSumHashed(nums, target)
    }

    fun twoSumHashed(nums: IntArray, target: Int): IntArray {
        val hashed = nums.withIndex().fold(mutableMapOf<Int, Int>()) { map, (idx, num) ->
            map.putIfAbsent(num, idx)
            map
        }
        for ((idx, num) in nums.withIndex()) {
            val diff = target - num
            val found = hashed[diff]
            found?.let { foundIdx ->
                if (idx != foundIdx) return intArrayOf(idx, foundIdx)
            }
        }
        return intArrayOf()
    }
}
