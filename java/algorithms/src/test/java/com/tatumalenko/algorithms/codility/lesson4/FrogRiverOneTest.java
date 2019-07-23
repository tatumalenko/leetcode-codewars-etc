package com.tatumalenko.algorithms.codility.lesson4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

class FrogRiverOneTest {

    @Test
    void findMinTime() {
        assertThat(new FrogRiverOne().findMinTime(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}))
                .isEqualTo(6);
    }
}