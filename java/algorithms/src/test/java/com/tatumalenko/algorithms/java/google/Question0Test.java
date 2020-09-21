package com.tatumalenko.algorithms.java.google;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Question0Test {

    @Test
    void solution() {
        final Question0 question0 = new Question0();

        final int[] input = {1, 2, 3, 4, 5};

        assertThat(Question0.solution(input)).isEqualTo(1);
    }

}