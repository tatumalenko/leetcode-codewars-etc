package com.tatumalenko.algorithms.kotlin.leetcode

object PartitionEqualSubsetSum416 {
    fun canPartition(nums: IntArray): Boolean {
        val subSetSum = nums.sum()
        if (subSetSum % 2 != 0 || nums.count() == 0) return false
        val targetSum = subSetSum / 2
        val a = Array(10) { 0 }
        return dfs(0, nums, targetSum)
    }

    private fun dfs(idx: Int, nums: IntArray, target: Int): Boolean {
        return when {
            idx == nums.count() || target < 0 -> false
            target == 0 -> true
            else -> dfs(idx + 1, nums, target - nums[idx]) || dfs(idx + 1, nums, target)
        }
    }
}
