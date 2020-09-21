package com.tatumalenko.algorithms.java.codility.lesson4;

public class MaxCounters {

    public static int[] solution(final int N, final int[] A) {
        final int[] B = new int[N];
        int max = 0;
        int pastMax = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == N + 1) {
                pastMax = max;
            } else {
                B[A[i] - 1] = Math.max(pastMax, B[A[i] - 1]);
                B[A[i] - 1]++;
                max = Math.max(B[A[i] - 1], max);
            }
        }

        for (int i = 0; i < B.length; i++) {
            B[i] = Math.max(pastMax, B[i]);
        }

        return B;
    }

}
