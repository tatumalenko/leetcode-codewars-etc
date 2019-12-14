package com.tatumalenko.algorithms.codility.lesson2;

public class CyclicRotation {

    public static int[] solution(final int[] A, final int K) {
        if (A.length == 0) {
            return A;
        }

        int currentK = K % A.length;

        while (currentK-- > 0) {
            rotate(A);
        }

        return A;
    }

    private static void rotate(final int[] array) {
        final int first = array[array.length - 1];

        for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }

        array[0] = first;
    }

}
