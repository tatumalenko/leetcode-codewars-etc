package com.tatumalenko.algorithms.java.codility.lesson6;

import java.util.Arrays;

public class Triangle {

    static int containsTriangularTriplet(final int[] A) {
        if (A.length < 3) {
            return 0;
        }

        Arrays.sort(A);

        for (int i = 2; i < A.length; i++) {
            if (A[i - 2] + A[i - 1] > A[i]
                && A[i - 1] + A[i] > A[i - 2]
                && A[i] + A[i - 2] > A[i - 1]
            ) {
                return 1;
            }
        }

        return 0;
    }

}
