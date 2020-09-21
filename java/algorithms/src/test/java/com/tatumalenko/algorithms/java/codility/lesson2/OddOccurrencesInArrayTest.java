package com.tatumalenko.algorithms.java.codility.lesson2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OddOccurrencesInArrayTest {

    @Test
    void solution() {
        assertThat(
            OddOccurrencesInArray.solution(new int[]{9, 3, 9, 3, 9, 7, 9})).isEqualTo(7);
    }

}