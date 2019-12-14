package com.tatumalenko.algorithms.google;

public class Question0 {
    int solution(int[] nums) {
        int sum1 = 0;
        int sum2 = 0;

        for (int a : nums) {
           if ((sum1 + a) > (sum2 + a)) {
               sum2 += a;
           } else {
               sum1 += a;
           }
        }

        return Math.abs(sum1 - sum2);
    }
}
