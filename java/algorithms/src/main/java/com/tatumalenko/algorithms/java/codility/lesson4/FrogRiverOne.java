package com.tatumalenko.algorithms.java.codility.lesson4;

public class FrogRiverOne {

    public static int findMinTime(final int X, final int[] A) {
        final int n = max(A);
        final int[] fmap = new int[n + 1];
        int needNext = 1;
        int time = 0;
        for (final int a : A) {
            fmap[a]++;
            while (fmap[needNext] > 0) {
                needNext++;
                if (needNext > X) {
                    break;
                }
            }
            if (needNext > X) {
                break;
            }
            time++;

        }
        return time;
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
