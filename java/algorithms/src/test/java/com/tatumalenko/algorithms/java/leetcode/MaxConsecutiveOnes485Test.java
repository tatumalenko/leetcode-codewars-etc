package com.tatumalenko.algorithms.java.leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MaxConsecutiveOnes485Test {

    @Test
    void one() {
        assertThat(MaxConsecutiveOnes485
            .findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}))
            .isEqualTo(3);
    }

    @Test
    void two() {
        assertThat(MaxConsecutiveOnes485
            .findMaxConsecutiveOnes(new int[]{0, 0, 0, 0, 0}))
            .isEqualTo(0);
    }

    @Test
    void three() {
        assertThat(MaxConsecutiveOnes485
            .findMaxConsecutiveOnes(new int[]{1, 1, 1, 1, 1, 1}))
            .isEqualTo(6);
    }

    @Test
    void four() {
        assertThat(MaxConsecutiveOnes485
            .findMaxConsecutiveOnes(new int[]{0}))
            .isEqualTo(0);
    }

    @Test
    void five() {
        assertThat(MaxConsecutiveOnes485
            .findMaxConsecutiveOnes(new int[]{1}))
            .isEqualTo(1);
    }

    @Test
    void six() {
        assertThat(MaxConsecutiveOnes485
            .findMaxConsecutiveOnes(new int[]{}))
            .isEqualTo(0);
    }

    @Test
    void seven() {
        assertThat(MaxConsecutiveOnes485
            .findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0}))
            .isEqualTo(3);
    }

}
