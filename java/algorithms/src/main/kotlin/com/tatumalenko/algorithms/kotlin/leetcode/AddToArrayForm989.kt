package com.tatumalenko.algorithms.kotlin.leetcode

object AddToArrayForm989 {
    fun addToArrayForm(A: IntArray, K: Int): List<Int> {
        return A.add(K.toIntArray()).toList()
    }

    fun IntArray.add(other: IntArray): IntArray {
        val larger = if (this.size > other.size) this else other
        val smaller = if (this.size > other.size) other else this
        val n = larger.size
        val output = IntArray(n + 1) { 0 }

        var leftover = 0
        for (i in 0 until n + 1) {
            if (i < larger.size) {
                val largerN = larger[larger.size - i - 1]
                val smallerN = if (i < smaller.size) smaller[smaller.size - i - 1] else 0

                if (largerN + smallerN + leftover > 9) {
                    output[n - i] = largerN + smallerN + leftover - 10
                    leftover = 1
                } else {
                    output[n - i] = largerN + smallerN + leftover
                    leftover = 0
                }
            } else {
                output[n - i] = leftover
            }
        }
        return if (output.first() == 0) output.drop(1).toIntArray() else output
    }

    fun Int.toIntArray(): IntArray {
        val n = this.numberOfDigits()
        val output = IntArray(n) { 0 }
        var temp = this

        for (i in 0 until n) {
            output[n - i - 1] = temp % 10
            temp /= 10
        }

        return output
    }

    fun Int.numberOfDigits(): Int {
        var temp = this
        var n = 1
        while (temp / 10 > 0) {
            n++
            temp /= 10
        }
        return n
    }
}
