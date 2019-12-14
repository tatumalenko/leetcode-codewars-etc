package com.tatumalenko.algorithms.google;

import java.util.ArrayList;
import java.util.Arrays;

public class Question1 {
    void solution(int[] nums, int k) {
        int first = 0;
        ArrayList<ArrayList<Integer>> arrayOfArrays =
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

    Integer[] findSubarray(Integer[] N, int K) {

        int num = N.length - K + 1;

        Integer arr[][] = new Integer[num][K];
        for (int i = 0; i < num; ++i) {
            Integer temp[] = new Integer[K];
            for (int j = i; j < i + K; ++j) {
                temp[j - i] = N[j];
            }
            arr[i] = temp;
        }
        Arrays.sort(arr, new java.util.Comparator<Integer[]>() {
            public int compare(Integer[] a, Integer[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        return arr[arr.length - 1];
    }
}
