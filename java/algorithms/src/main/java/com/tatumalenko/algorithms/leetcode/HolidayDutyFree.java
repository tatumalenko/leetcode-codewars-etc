package com.tatumalenko.algorithms.leetcode;

public class HolidayDutyFree {

    public static int dutyFree(int normPrice, int discount, int hol) {
        var n = 1;

        while (normPrice * (discount / 100.0) * n <= hol) {
            n += 1;
        }

        return n;
    }

    public static void main(String[] args) {
        System.out.println(dutyFree(17, 10, 500));
    }

}
