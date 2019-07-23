package com.tatumalenko.algorithms.codility.lesson3;

import com.tatumalenko.algorithms.util.AlgorithmUtils;

public class MushroomPicker {

    public int findMaxMushrooms(int[] A, int startIdx, int moves) {
        int[] prefixSums = getPrefixSums(A);
        int n = A.length;
        int max = 0;
        for (int leftIdx = startIdx; leftIdx >= 0 && (startIdx - leftIdx) <= moves; leftIdx--) {
            int leftSteps = startIdx - leftIdx;
            int rightIdx = Math.min(leftIdx + moves - leftSteps, n - 1);
            int rangeSum = prefixSums[rightIdx] - prefixSums[leftIdx] + A[leftIdx];
            if (rangeSum > max) { max = rangeSum; }
        }
        return max;
    }

    private int[] getPrefixSums(int[] A) {
        return AlgorithmUtils.getPrefixSums(A);
    }

}
