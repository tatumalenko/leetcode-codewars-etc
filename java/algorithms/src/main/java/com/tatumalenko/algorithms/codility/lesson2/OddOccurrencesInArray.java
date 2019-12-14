package com.tatumalenko.algorithms.codility.lesson2;

import java.util.HashMap;
import java.util.Map;

public class OddOccurrencesInArray {

    public static int solution(final int[] input) {
        final Map<Integer, Integer> map = new HashMap<>();

        for (final int number : input) {
            if (map.containsKey(number)) {
                map.put(number, map.get(number) + 1);
            } else {
                map.put(number, 1);
            }
        }

        for (final Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                return entry.getKey();
            }
        }

        return -1;
    }

}
