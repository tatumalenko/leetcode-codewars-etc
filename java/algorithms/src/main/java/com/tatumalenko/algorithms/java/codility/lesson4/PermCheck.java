package com.tatumalenko.algorithms.java.codility.lesson4;

/**
 * A non-empty array A consisting of N integers is given. A permutation is a sequence
 * containing each element from 1 to N once, and only once.
 * <p>
 * For example, array A such that:
 * <p>
 * {@code A[0] = 4, A[1] = 1, A[2] = 3, A[3] = 2}
 * <p>
 * is a permutation, but array A such that:
 * <p>
 * {@code A[0] = 4, A[1] = 1, A[2] = 3}
 * <p>
 * is not a permutation, because value 2 is missing. The goal is to check whether array A
 * is a permutation. Write a function:
 * <p>
 * {@code class Solution { public int solution(int[] A); }}
 * <p>
 * that, given an array A, returns 1 if array A is a permutation and 0 if it is not.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <ul>
 * <li>N is an integer within the range [1..100,000]</li>
 * <li>Each element of array A is an integer within the range [1..1,000,000,000]</li>
 * </ul>
 */
public class PermCheck {

    public static int isPermutationArray(final int[] nums) {
//        int n = nums.length;
//        int arithmeticSum = n * (1 + n) / 2;
//        int sumSoFar = 0;
//        for (int num : nums) {
//            sumSoFar += num;
//            if (sumSoFar > arithmeticSum) {
//                return 0;
//            }
//        }
//        if (sumSoFar != arithmeticSum) {
//            return 0;
//        }
        // Need map, sum too big, will overflow.
        final int[] fMap = getFrequencyMap(nums);
        for (final int num : fMap) {
            if (num == 0) {
                return 0;
            }
        }
        return 1;
    }

    private static int[] getFrequencyMap(final int[] nums) {
        final int n = nums.length;
        final int[] map = new int[n];
        for (final int num : nums) {
            if (num <= n) {
                map[num - 1]++;
            }
        }
        return map;
    }

}
