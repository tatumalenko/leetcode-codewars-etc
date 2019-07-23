package com.tatumalenko.algorithms.codility.lesson6;

import java.util.Arrays;

public class Distinct {

    int findNumOfUniqInts(int[] A) {
        if (A.length == 0 || A.length == 1) {
            return A.length;
        }

        int count = 1;
        Arrays.sort(A);
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[i - 1]) {
                count++;
            }
        }

        return count;
    }

}
