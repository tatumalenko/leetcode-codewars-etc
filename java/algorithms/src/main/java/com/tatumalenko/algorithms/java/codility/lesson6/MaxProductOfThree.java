package com.tatumalenko.algorithms.java.codility.lesson6;

import java.util.Arrays;

public class MaxProductOfThree {

    public static int findMaxProductOfThree(final int[] A) {
        final int n = A.length;
        Arrays.sort(A);
        return Math.max(A[n - 3] * A[n - 2] * A[n - 1],
            Math.max(A[0] * A[1] * A[2],
                Math.max(A[0] * A[1], A[n - 2] * A[n - 3]) * A[n - 1]));
    }

}
