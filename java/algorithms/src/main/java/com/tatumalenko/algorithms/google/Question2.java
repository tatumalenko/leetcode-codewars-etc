package com.tatumalenko.algorithms.google;

public class Question2 {
    int[] solution(String A, String B) {
        String[] aWords = A.split(",");
        String[] bWords = B.split(",");
        int[] freqs = new int[bWords.length];
        int freqsPtr = 0;

        for (String bWord : bWords) {
            int freqOfB = frequencyOfSmallestChar(bWord);
            for (String aWord : aWords) {
                int freqOfA = frequencyOfSmallestChar(aWord);

                if (freqOfA < freqOfB) {
                    freqs[freqsPtr]++;
                }
            }
            freqsPtr++;
        }

        return freqs;
    }

    int frequencyOfSmallestChar(String string) {
        char[] chars = string.toCharArray();
        int freq = 0;
        char smallestChar = chars[0];

        for (char c : chars) {
            if (c < smallestChar) {
                smallestChar = c;
            }
        }

        for (char c : chars) {
            if (c == smallestChar) {
                freq++;
            }
        }

        return freq;
    }
}
