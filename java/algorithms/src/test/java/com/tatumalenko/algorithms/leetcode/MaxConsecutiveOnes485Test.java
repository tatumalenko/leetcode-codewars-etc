package com.tatumalenko.algorithms.leetcode;

import com.tatumalenko.algorithms.leetcode.MaxConsecutiveOnes485;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MaxConsecutiveOnes485Test {

    @Test
    void one() {
        assertThat(new MaxConsecutiveOnes485()
                .findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}))
                .isEqualTo(3);
    }

    @Test
    void two() {
        assertThat(new MaxConsecutiveOnes485()
                .findMaxConsecutiveOnes(new int[]{0, 0, 0, 0, 0}))
                .isEqualTo(0);
    }

    @Test
    void three() {
        assertThat(new MaxConsecutiveOnes485()
                .findMaxConsecutiveOnes(new int[]{1, 1, 1, 1, 1, 1}))
                .isEqualTo(6);
    }

    @Test
    void four() {
        assertThat(new MaxConsecutiveOnes485()
                .findMaxConsecutiveOnes(new int[]{0}))
                .isEqualTo(0);
    }

    @Test
    void five() {
        assertThat(new MaxConsecutiveOnes485()
                .findMaxConsecutiveOnes(new int[]{1}))
                .isEqualTo(1);
    }

    @Test
    void six() {
        assertThat(new MaxConsecutiveOnes485()
                .findMaxConsecutiveOnes(new int[]{}))
                .isEqualTo(0);
    }

    @Test
    void seven() {
        assertThat(new MaxConsecutiveOnes485()
                .findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0}))
                .isEqualTo(3);
    }

}
