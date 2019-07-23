package com.tatumalenko.algorithms.util;

public class AlgorithmUtils {

    private AlgorithmUtils() {
        throw new IllegalStateException("Util class");
    }

    public static int[] getPrefixSums(int[] A) {
        int[] sums = new int[A.length];
        sums[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            sums[i] = A[i] + sums[i - 1];
        }
        return sums;
    }

}
