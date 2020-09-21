package com.tatumalenko.algorithms.java.google;

public class Question0 {

    static int solution(final int[] nums) {
        int sum1 = 0;
        int sum2 = 0;

        for (final int a : nums) {
            if ((sum1 + a) > (sum2 + a)) {
                sum2 += a;
            } else {
                sum1 += a;
            }
        }

        return Math.abs(sum1 - sum2);
    }

}
