package com.tatumalenko.algorithms.codility.lesson6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Java6Assertions.assertThat;

class MaxProductOfThreeTest {

    @ParameterizedTest
    @MethodSource("provider")
    void findMaxProductOfThree(int[] input, int expected) {
        assertThat(new MaxProductOfThree().findMaxProductOfThree(input))
                .isEqualTo(expected);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(new int[]{-3, 1, 2, -2, 5, 6}, 60)
        );
    }
}