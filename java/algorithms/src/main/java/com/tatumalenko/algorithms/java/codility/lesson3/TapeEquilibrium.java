package com.tatumalenko.algorithms.java.codility.lesson3;

/**
 * Given a non-empty array A of N integers, returns the minimal difference that can be
 * achieved.
 * <p>
 * A non-empty array A consisting of N integers is given. Array A represents numbers on a
 * tape.
 * <p>
 * Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0],
 * A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
 * <p>
 * The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) −
 * (A[P] + A[P + 1] + ... + A[N − 1])|
 * <p>
 * In other words, it is the absolute difference between the sum of the first part and the
 * sum of the second part.
 */
public class TapeEquilibrium {

    public static int findMinDifference(final int[] nums) {
        int sum = 0;
        for (final int num : nums) {
            sum += num;
        }
        int minDiff = Integer.MAX_VALUE;
        int sumSoFar = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            sumSoFar += nums[i];
            final int curDiff = Math.abs(sumSoFar - (sum - sumSoFar));
            if (curDiff < minDiff) {
                minDiff = curDiff;
            }
        }
        return minDiff;
    }

}
