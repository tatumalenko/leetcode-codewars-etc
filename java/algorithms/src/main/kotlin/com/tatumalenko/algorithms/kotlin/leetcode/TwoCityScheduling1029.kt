package com.tatumalenko.algorithms.kotlin.leetcode

object TwoCityScheduling1029 {
    fun twoCitySchedCost(costs: Array<IntArray>): Int {
        val queueA = ArrayDeque<Int>()
        val queueB = ArrayDeque<Int>()

        for ((costA, costB) in costs) {
            queueA.addLast(costA)
            queueB.addLast(costB)
            queueA.sort()
            queueB.sort()
        }

        val n = costs.size / 2
        var sum = 0
        for ((costA, costB) in queueA.zip(queueB)) {
            sum += costA + costB
        }

        return sum
    }
}
