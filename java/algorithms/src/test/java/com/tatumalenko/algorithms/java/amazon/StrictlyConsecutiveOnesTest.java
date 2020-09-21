package com.tatumalenko.algorithms.java.amazon;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StrictlyConsecutiveOnesTest {

    @ParameterizedTest
    @MethodSource("testProvider")
    void test(final int[] input, final boolean expected) {
        assertThat(StrictlyConsecutiveOnes
            .isConsecutiveOnes(input))
            .isEqualTo(expected);
    }

    private static Stream<Arguments> testProvider() {
        return Stream.of(
            Arguments.of(new int[]{1, 1, 0, 1, 1, 1}, false),
            Arguments.of(new int[]{1, 1, 1, 1, 1, 1}, true),
            Arguments.of(new int[]{1, 1, 0, 0, 3, 4}, true),
            Arguments.of(new int[]{0, 0, 0, 0, 1, 0}, true),
            Arguments.of(new int[]{0, 0, 0, 0, 1, 1}, true)
        );
    }

}
