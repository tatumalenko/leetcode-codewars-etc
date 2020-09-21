package com.tatumalenko.algorithms.java.google;

import java.util.ArrayList;
import java.util.Arrays;

public class Question1 {

    static void solution(final int[] nums, final int k) {
        int first = 0;
        final ArrayList<ArrayList<Integer>> arrayOfArrays =
            new ArrayList<>();

        int currentArrayListIndex = 0;
        while (first + k <= nums.length) {
            arrayOfArrays.add(new ArrayList<>());
            for (int i = first; i < first + k; i++) {
                arrayOfArrays.get(currentArrayListIndex).add(nums[i]);
            }
            currentArrayListIndex++;
            first++;
        }

        for (int i = 0; i < k; i++) {

        }

        System.out.println(arrayOfArrays);
    }

    static Integer[] findSubarray(final Integer[] N, final int K) {

        final int num = N.length - K + 1;

        final Integer[][] arr = new Integer[num][K];
        for (int i = 0; i < num; ++i) {
            final Integer[] temp = new Integer[K];
            for (int j = i; j < i + K; ++j) {
                temp[j - i] = N[j];
            }
            arr[i] = temp;
        }
        Arrays.sort(arr, new java.util.Comparator<Integer[]>() {
            @Override
            public int compare(final Integer[] a, final Integer[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        return arr[arr.length - 1];
    }

}
