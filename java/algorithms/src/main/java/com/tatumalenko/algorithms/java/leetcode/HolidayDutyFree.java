package com.tatumalenko.algorithms.java.leetcode;

public class HolidayDutyFree {

    public static int dutyFree(final int normPrice, final int discount, final int hol) {
        var n = 1;

        while (normPrice * (discount / 100.0) * n <= hol) {
            n += 1;
        }

        return n;
    }

    public static void main(final String[] args) {
        System.out.println(dutyFree(17, 10, 500));
    }

}
