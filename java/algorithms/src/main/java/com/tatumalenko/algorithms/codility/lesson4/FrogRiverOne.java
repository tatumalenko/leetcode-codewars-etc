package com.tatumalenko.algorithms.codility.lesson4;

public class FrogRiverOne {
    public int findMinTime(int X, int[] A) {
        int n = max(A);
        int[] fmap = new int[n + 1];
        int needNext = 1;
        int time = 0;
        for (int a : A) {
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
