package com.tatumalenko.algorithms.java.codility.lesson3;

public class FrogJmp {

    public static int solution(final int X, final int Y, final int D) {
        final int Z = closestMultiple(D, Y - X);
        final int N = Z / D;
        final int yN = X + D * N;
        final int yNm1 = X + D * (N - 1);
        final int yNp1 = X + D * (N + 1);

        if (yNm1 >= Y) {
            return N - 1;
        } else if (yN >= Y) {
            return N;
        } else if (yNp1 >= Y) {
            return N + 1;
        } else {
            throw new RuntimeException("Fuck.");
        }
    }

    private static int closestMultiple(final int low, final int high) {
        final int remainder = high % low;

        if ((high - remainder) % low == 0) {
            return high - remainder;
        } else {
            return high + remainder;
        }
    }

}
