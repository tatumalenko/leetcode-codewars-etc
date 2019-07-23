package com.tatumalenko.algorithms.codility.lesson3;

/**
 * An array A consisting of N different integers is given. The array contains integers in
 * the range [1..(N + 1)], which means that exactly one element is missing.
 * <p>
 * Your goal is to find that missing element.
 * <p>
 * <a href="https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/">
 * Codility: PermMissingElem</a>
 */
public class PermMissingElem {
    public int findMissingElement(int[] A) {
        int actualSum = 0;
        int expectedSum = 0;
        for (int i = 0; i < A.length; i++) {
            actualSum += A[i];
            expectedSum += i + 1;
        }
        expectedSum += A.length + 1;
        return expectedSum - actualSum;
    }
}
