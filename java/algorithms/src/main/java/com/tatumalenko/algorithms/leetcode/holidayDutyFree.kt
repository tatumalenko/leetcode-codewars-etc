package com.tatumalenko.algorithms.leetcode

import java.lang.Math.floor


class HolidayDutyFreeKt {
    fun dutyFree(normPrice: Int, discount: Int, hol: Int): Int {
        var n = 1

        while (normPrice * discount / 100 * n <= hol) {
            n += 1
        }
        floor(1.2)
        return n
    }

    fun main() {
        System.out.println(dutyFree(17, 10, 500))
    }
}

