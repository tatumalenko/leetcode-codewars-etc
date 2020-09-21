package com.tatumalenko.algorithms.kotlin.leetcode

object ThreeSum15 {
    fun threeSum(nums: IntArray): List<List<Int>> {
        return threeSumSort(nums)
    }

    fun threeSumSort(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        nums.sort()

        for (i in 0 until nums.count()) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue
            }
            val partialTarget = 0 - nums[i]
            var j = i + 1
            var k = nums.count() - 1
            while (j < k) {
                val partialSum = nums[j] + nums[k]
                val difference = partialTarget - partialSum
                when {
                    difference > 0 -> {
                        val idx = j
                        while (nums[idx] == nums[j] && j < k) j++
                    }
                    difference < 0 -> {
                        val idx = k
                        while (nums[idx] == nums[k] && k > j) k--
                    }
                    else -> {
                        result.add(listOf(nums[i], nums[j], nums[k]))
                        val idx = j
                        while (nums[idx] == nums[j] && j < k) j++

                    }
                }
            }
        }

        return result
    }

}