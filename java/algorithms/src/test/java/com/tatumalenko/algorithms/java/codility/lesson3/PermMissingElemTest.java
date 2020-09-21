package com.tatumalenko.algorithms.java.codility.lesson3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

class PermMissingElemTest {

    @Test
    void findMissingElement() {
        assertThat(PermMissingElem.findMissingElement(new int[]{2, 3, 1, 5}))
            .isEqualTo(4);
    }

}