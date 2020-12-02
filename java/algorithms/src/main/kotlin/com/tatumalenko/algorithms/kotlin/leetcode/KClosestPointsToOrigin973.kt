package com.tatumalenko.algorithms.kotlin.leetcode

import kotlin.math.pow

object KClosestPointsToOrigin973 {
    fun kClosest(points: Array<IntArray>, K: Int): Array<IntArray> {
        val pairs = Array(points.size) { Pair(0, 0.0) }
        for (i in points.indices) {
            val point = points[i]
            val x = point[0]
            val y = point[1]
            pairs[i] = Pair(i, (x.toDouble().pow(2) + y.toDouble().pow(2)).pow(0.5))
        }
        pairs.sortBy { (_, d) -> d }
        return pairs.map { (i, _) -> points[i] }.take(K).toTypedArray()
    }
}
