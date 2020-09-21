package com.tatumalenko.algorithms.java.codility.lesson6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TriangleTest {

    @ParameterizedTest
    @MethodSource("provider")
    void containsTriangularTriplet(final int[] input, final int expected) {
        assertThat(Triangle.containsTriangularTriplet(input))
            .isEqualTo(expected);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
            Arguments.of(
                new int[]{10, 2, 5, 1, 8, 20}, 1
            )
        );
    }

}