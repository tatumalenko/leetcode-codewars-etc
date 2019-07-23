package com.tatumalenko.algorithms.codility.lesson4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Java6Assertions.assertThat;

class PermCheckTest {

    @ParameterizedTest
    @MethodSource("isPermutationArrayProvider")
    void isPermutationArray(int[] input, int expected) {
        assertThat(new PermCheck().isPermutationArray(input))
                .isEqualTo(expected);
    }

    static Stream<Arguments> isPermutationArrayProvider() {
        return Stream.of(
                Arguments.of(new int[]{4, 1, 3, 2}, 1),
                Arguments.of(new int[]{1, 4, 1}, 0),
                Arguments.of(new int[]{2}, 0),
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{1, 3}, 0)
        );
    }
}