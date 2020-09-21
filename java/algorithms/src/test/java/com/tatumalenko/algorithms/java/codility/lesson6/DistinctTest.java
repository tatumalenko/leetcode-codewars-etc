package com.tatumalenko.algorithms.java.codility.lesson6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DistinctTest {

    @ParameterizedTest
    @MethodSource("provider")
    void findNumOfUniqInts(final int[] input, final int expected) {
        assertThat(Distinct.findNumOfUniqInts(input)).isEqualTo(expected);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
            Arguments.of(new int[]{2, 1, 1, 2, 3, 1}, 3),
            Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 1}, 1),
            Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 7)
        );
    }

}