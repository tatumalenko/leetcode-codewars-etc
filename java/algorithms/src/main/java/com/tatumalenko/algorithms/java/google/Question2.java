package com.tatumalenko.algorithms.java.google;

public class Question2 {

    int[] solution(final String A, final String B) {
        final String[] aWords = A.split(",");
        final String[] bWords = B.split(",");
        final int[] freqs = new int[bWords.length];
        int freqsPtr = 0;

        for (final String bWord : bWords) {
            final int freqOfB = frequencyOfSmallestChar(bWord);
            for (final String aWord : aWords) {
                final int freqOfA = frequencyOfSmallestChar(aWord);

                if (freqOfA < freqOfB) {
                    freqs[freqsPtr]++;
                }
            }
            freqsPtr++;
        }

        return freqs;
    }

    int frequencyOfSmallestChar(final String string) {
        final char[] chars = string.toCharArray();
        int freq = 0;
        char smallestChar = chars[0];

        for (final char c : chars) {
            if (c < smallestChar) {
                smallestChar = c;
            }
        }

        for (final char c : chars) {
            if (c == smallestChar) {
                freq++;
            }
        }

        return freq;
    }

}
