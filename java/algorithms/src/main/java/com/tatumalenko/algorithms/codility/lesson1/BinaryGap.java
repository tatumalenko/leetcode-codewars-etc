package com.tatumalenko.algorithms.codility.lesson1;

public class BinaryGap {

    public static int solution(int input) {
        String binary = Integer.toBinaryString(input);
        int left = 0;
        int ctr = 0;
        int max = 0;

        for (char c : binary.toCharArray()) {
            int digit = (int) c - (int) '0';

            if (digit == 1 && left == 0) {
                left = 1;
            } else if (digit == 1) {
                max = Math.max(max, ctr);
                ctr = 0;
            } else if (digit == 0 && left == 1) {
                ctr++;
            }
        }

        return max;
    }

}