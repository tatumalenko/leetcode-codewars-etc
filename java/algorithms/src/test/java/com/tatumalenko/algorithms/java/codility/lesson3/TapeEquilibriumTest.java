package com.tatumalenko.algorithms.java.codility.lesson3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Java6Assertions.assertThat;

class TapeEquilibriumTest {

    @ParameterizedTest
    @MethodSource("findMinDifferenceProvider")
    void findMinDifference(final int[] input, final int expected) {
        assertThat(TapeEquilibrium.findMinDifference(input))
            .isEqualTo(expected);
    }

    static Stream<Arguments> findMinDifferenceProvider() {
        return Stream.of(
            Arguments.of(new int[]{3, 1, 2, 4, 3}, 1),
            Arguments.of(new int[]{-1, -2, 3, 3, 4, 8}, 1),
            Arguments.of(new int[]{-1, -2, 3, 3, 4, 7}, 0),
            Arguments.of(new int[]{-1000, 1000}, 2000),
            Arguments.of(new int[]{-1000, -1000}, 0)
        );
    }

}