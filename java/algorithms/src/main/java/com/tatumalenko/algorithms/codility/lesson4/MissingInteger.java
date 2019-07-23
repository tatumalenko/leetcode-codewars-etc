package com.tatumalenko.algorithms.codility.lesson4;

public class MissingInteger {

    public int findSmallestPositiveInt(int[] A) {
        int n = A.length;
        int max = max(A);
        if (max == -1) {
            return 1;
        }
        int[] map = new int[max];
        for (int a : A) {
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

    private static int max(int[] A) {
        int n = Integer.MIN_VALUE;
        for (int a : A) {
            if (a > n) {
                n = a;
            }
        }
        return n;
    }

}
