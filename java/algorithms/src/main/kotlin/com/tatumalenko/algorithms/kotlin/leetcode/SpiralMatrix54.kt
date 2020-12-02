package com.tatumalenko.algorithms.kotlin.leetcode

object SpiralMatrix54 {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val m = matrix.size
        val n = matrix[0].size
        val mn = m * n
        val output = mutableListOf<Int>()
        var r = 0
        val dr = intArrayOf(0, 1, 0, -1)
        var c = 0
        val dc = intArrayOf(1, 0, -1, 0)
        var di = 0
        val seen = matrix.map { it.map { false }.toTypedArray() }.toTypedArray()
        for (i in 0 until mn) {
            output.add(matrix[r][c])
            seen[r][c] = true
            val cr = r + dr[di]
            val cc = c + dc[di]
            if (cr in 0 until m && cc in 0 until n && !seen[cr][cc]) {
                r = cr
                c = cc
            } else {
                di = (di + 1) % 4
                r += dr[di]
                c += dc[di]
            }
        }
        return output
    }
}
