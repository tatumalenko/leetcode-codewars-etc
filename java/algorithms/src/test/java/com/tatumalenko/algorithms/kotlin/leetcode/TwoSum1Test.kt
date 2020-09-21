package com.tatumalenko.algorithms.kotlin.leetcode

import org.junit.jupiter.api.Test

internal class TwoSum1Test {
    @Test
    fun test1() {
        val actual = TwoSum1.twoSum(intArrayOf(2, 7, 11, 15), 9)
        val expected = intArrayOf(0, 1)
        assert(actual.contentEquals(expected))
    }

    @Test
    fun test2() {
        val actual = TwoSum1.twoSum(intArrayOf(3, 2, 4), 6)
        val expected = intArrayOf(1, 2)
        assert(actual.contentEquals(expected))
    }
}