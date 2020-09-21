package com.tatumalenko.algorithms.kotlin.leetcode

import org.junit.jupiter.api.Test

internal class PartitionEqualSubsetSum416Test {

    @Test
    fun canPartition() {
        assert(PartitionEqualSubsetSum416.canPartition(intArrayOf(1, 5, 11, 5)))
        assert(!PartitionEqualSubsetSum416.canPartition(intArrayOf(1, 2, 3, 5)))
    }

}