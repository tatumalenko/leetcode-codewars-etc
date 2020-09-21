package com.tatumalenko.algorithms.java.codility.lesson3;

import com.tatumalenko.algorithms.java.util.AlgorithmUtils;

public class MushroomPicker {

    public int findMaxMushrooms(final int[] A, final int startIdx, final int moves) {
        final int[] prefixSums = getPrefixSums(A);
        final int n = A.length;
        int max = 0;
        for (int leftIdx = startIdx; leftIdx >= 0 && (startIdx - leftIdx) <= moves; leftIdx--) {
            final int leftSteps = startIdx - leftIdx;
            final int rightIdx = Math.min(leftIdx + moves - leftSteps, n - 1);
            final int rangeSum = prefixSums[rightIdx] - prefixSums[leftIdx] + A[leftIdx];
            if (rangeSum > max) {
                max = rangeSum;
            }
        }
        return max;
    }

    private int[] getPrefixSums(final int[] A) {
        return AlgorithmUtils.getPrefixSums(A);
    }

}
