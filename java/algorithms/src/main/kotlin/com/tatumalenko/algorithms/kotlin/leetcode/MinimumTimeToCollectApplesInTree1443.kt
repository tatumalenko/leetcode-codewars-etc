package com.tatumalenko.algorithms.kotlin.leetcode

import java.util.*

object MinimumTimeToCollectApplesInTree1443 {

    fun minTime(n: Int, edges: Array<IntArray>, hasApple: List<Boolean>): Int {
        return minTimeRecursive(0, edges, hasApple) * 2
    }

    fun minTimeRecursive(vertex: Int, edges: Array<IntArray>, hasApple: List<Boolean>): Int {
        return when {
            vertex >= hasApple.size -> 0
            shouldKeepGoing(vertex, edges, hasApple) ->
                (if (vertex == 0) 0 else 1) +
                    nextVertices(vertex, edges).fold(0) { sum, v -> sum + minTimeRecursive(v, edges, hasApple) }
            else -> 0
        }
    }

    fun nextVertices(vertex: Int, edges: Array<IntArray>): Set<Int> {
        val reached = mutableSetOf<Int>()
        for ((from, to) in edges) {
            if (vertex == from) {
                reached.add(to)
            }
        }
        return reached
    }

    fun reachedVertices(vertex: Int, edges: Array<IntArray>): Set<Int> {
        val reached = mutableSetOf<Int>()
        reached.add(vertex)
        val stack = ArrayDeque<Int>()
        stack.add(vertex)

        while (stack.isNotEmpty()) {
//            val currentIndex = stack.removeFirstOrNull()
//            currentIndex.let { index ->
//                for ((from, to) in edges) {
//                    if (from == index && !reached.contains(to)) {
//                        reached.add(to)
//                        stack.addLast(to)
//                    }
//                }
//            }
        }

        return reached
    }

    fun shouldKeepGoing(vertex: Int, edges: Array<IntArray>, hasApple: List<Boolean>): Boolean {
        val reachedVertices = reachedVertices(vertex, edges)

        for (reached in reachedVertices) {
            if (hasApple[reached]) {
                return true
            }
        }

        return false
    }
}