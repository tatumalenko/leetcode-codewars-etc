package com.tatumalenko.algorithms.kotlin.leetcode

import org.junit.jupiter.api.Test

internal class ThreeSum15Test {
    @Test
    fun threeSum1() {
        val actual = ThreeSum15.threeSum(intArrayOf(-1, 0, 1, 2, -1, -4))
        val expected = mutableListOf(listOf(-1, -1, 2), listOf(-1, 0, 1))
        assert(actual == expected)
    }

    @Test
    fun threeSum2() {
        val actual = ThreeSum15.threeSum(intArrayOf(0, 0, 0))
        val expected = mutableListOf(listOf(0, 0, 0))
        assert(actual == expected)
    }

    @Test
    fun threeSum3() {
        val actual = ThreeSum15.threeSum(intArrayOf(0, 0, 0, 0))
        val expected = mutableListOf(listOf(0, 0, 0))
        assert(actual == expected)
    }
}