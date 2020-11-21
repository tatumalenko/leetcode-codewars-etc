package com.tatumalenko.algorithms.kotlin.leetcode

object MaxConsecutiveOnes1004 {
    fun longestOnes(A: IntArray, K: Int): Int {
        val queue = ArrayDeque<Int>()
        var max = 0
        var right = 0
        var left = 0

        for (j in A.indices) {
            right = j

            if (A[j] == 0) {
                queue.addLast(j)
                if (queue.size > K) {
                    max = maxOf(max, j - left)
                    left = queue.removeFirst() + 1
                }
            }

            max = maxOf(max, right - left)
        }

        return maxOf(max, right - left + 1)
    }
}
