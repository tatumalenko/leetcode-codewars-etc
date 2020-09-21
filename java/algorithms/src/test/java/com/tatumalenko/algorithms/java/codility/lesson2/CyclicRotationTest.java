package com.tatumalenko.algorithms.java.codility.lesson2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CyclicRotationTest {

    @ParameterizedTest
    @MethodSource("provider")
    void solution(final int[] A, final int K, final int[] expected) {
        assertThat(CyclicRotation.solution(A, K)).isEqualTo(expected);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
            Arguments.of(new int[]{3, 8, 9, 7, 6}, 3, new int[]{9, 7, 6, 3, 8}),
            Arguments.of(new int[]{3, 8, 9, 7, 6}, 1, new int[]{6, 3, 8, 9, 7}),
            Arguments.of(new int[]{3, 8, 9, 7, 6}, 2, new int[]{7, 6, 3, 8, 9}),
            Arguments.of(new int[]{3, 8, 9, 7, 6}, 4, new int[]{8, 9, 7, 6, 3}),
            Arguments.of(new int[]{0, 0, 0}, 1, new int[]{0, 0, 0}),
            Arguments.of(new int[]{1, 2, 3, 4}, 4, new int[]{1, 2, 3, 4}),
            Arguments.of(new int[]{}, 2, new int[]{})
        );
    }

}