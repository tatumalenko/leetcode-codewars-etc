package com.tatumalenko.algorithms.google;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Question0Test {

    @Test
    void solution() {
        Question0 question0 = new Question0();

        int[] input = {1, 2, 3, 4, 5};

        assertThat(question0.solution(input)).isEqualTo(1);
    }
}