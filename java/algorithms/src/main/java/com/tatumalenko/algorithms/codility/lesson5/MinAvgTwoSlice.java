package com.tatumalenko.algorithms.codility.lesson5;

import com.tatumalenko.algorithms.util.AlgorithmUtils;

public class MinAvgTwoSlice {

    public int findMinAvgSlideFirstIndex(int[] A) {
        int[] prefixSums = getPrefixSums(A);
        int minIdx;
        int leftIdx;
        double minAvg;
        double twoAvg;
        double prevAvg;
        double hereAvg;

        leftIdx = minIdx = 0;
        hereAvg = (A[0] + A[1]) / 2.0;
        minAvg = hereAvg;

        for (int i = 2; i < prefixSums.length; i++) {
            prevAvg =
                    (prefixSums[i + 1] - prefixSums[leftIdx]) / (i - leftIdx + 1);

            twoAvg = (A[i - 1] + A[i]) / 2.0;

            if (twoAvg < prevAvg) {
                hereAvg = twoAvg;
                leftIdx = i - 1;
            } else {
                hereAvg = prevAvg;
            }

            if (hereAvg < minAvg) {
                minAvg = hereAvg;
                minIdx = leftIdx;
            }
        }

        return minIdx;
    }

    private static int[] getPrefixSums(int[] A) {
        return AlgorithmUtils.getPrefixSums(A);
    }

}
