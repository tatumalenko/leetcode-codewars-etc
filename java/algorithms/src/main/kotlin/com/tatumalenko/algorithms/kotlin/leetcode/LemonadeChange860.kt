package com.tatumalenko.algorithms.kotlin.leetcode

object LemonadeChange860 {
    fun lemonadeChange(bills: IntArray): Boolean {
        val idxFive = 2
        val idxTen = 1
        val idxTwenty = 0

        val reserve = Array(3) { 0 }

        for (bill in bills) {
            when (bill) {
                5 -> reserve[idxFive]++
                10 -> {
                    when {
                        reserve[idxFive] > 0 -> {
                            reserve[idxFive]--
                            reserve[idxTen]++
                        }
                        else -> return false
                    }
                }
                20 -> {
                    when {
                        reserve[idxTen] > 0 && reserve[idxFive] > 0 -> {
                            reserve[idxTen]--
                            reserve[idxFive]--
                            reserve[idxTwenty]++
                        }
                        reserve[idxFive] > 2 -> {
                            reserve[idxFive] -= 3
                            reserve[idxTwenty]++
                        }
                        else -> return false
                    }
                }
            }
        }

        return true
    }
}