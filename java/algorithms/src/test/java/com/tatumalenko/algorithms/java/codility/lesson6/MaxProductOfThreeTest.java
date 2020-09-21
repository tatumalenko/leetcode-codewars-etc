package com.tatumalenko.algorithms.java.codility.lesson6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Java6Assertions.assertThat;

class MaxProductOfThreeTest {

    @ParameterizedTest
    @MethodSource("provider")
    void findMaxProductOfThree(final int[] input, final int expected) {
        assertThat(MaxProductOfThree.findMaxProductOfThree(input))
            .isEqualTo(expected);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
            Arguments.of(new int[]{-3, 1, 2, -2, 5, 6}, 60)
        );
    }

}