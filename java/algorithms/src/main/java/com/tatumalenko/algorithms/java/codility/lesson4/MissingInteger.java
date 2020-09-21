package com.tatumalenko.algorithms.java.codility.lesson4;

public class MissingInteger {

    public static int findSmallestPositiveInt(final int[] A) {
        final int n = A.length;
        final int max = max(A);
        if (max == -1) {
            return 1;
        }
        final int[] map = new int[max];
        for (final int a : A) {
            if (a > 0) {
                map[a - 1]++;
            }
        }
        for (int i = 0; i < max; i++) {
            if (map[i] == 0) {
                return i + 1;
            }
        }
        return max + 1;
    }

    private static int max(final int[] A) {
        int n = Integer.MIN_VALUE;
        for (final int a : A) {
            if (a > n) {
                n = a;
            }
        }
        return n;
    }

}
