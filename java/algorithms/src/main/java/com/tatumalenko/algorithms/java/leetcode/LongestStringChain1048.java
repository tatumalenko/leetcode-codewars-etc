package com.tatumalenko.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestStringChain1048 {

    public static int longestStringChain(final String[] words) {
        final Map<String, Integer> map = new HashMap<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));

        for (final String word : words) {
            final List<String> subWords = dropOneLetterSubWords(word);

            final int longestChainSizeSoFar = subWords.stream()
                .map(subWord -> map.getOrDefault(subWord, 0))
                .reduce(0, Math::max);

            map.put(word, longestChainSizeSoFar + 1);
        }

        return map.values().stream()
            .max(Comparator.comparingInt(Integer::intValue))
            .orElse(0);
    }

    private static List<String> dropOneLetterSubWords(final String word) {
        final List<String> subWords = new ArrayList<>(word.length());
        for (int i = 0; i < word.length(); i++) {
            subWords.add(word.substring(0, i) + word.substring(i + 1));
        }
        return subWords;
    }

}
