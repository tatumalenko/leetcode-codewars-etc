package com.tatumalenko.algorithms.codility.lesson4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Java6Assertions.assertThat;

class MissingIntegerTest {

    @ParameterizedTest
    @MethodSource("provider")
    void findSmallestPositiveInt(int[] input, int expected) {
        assertThat(new MissingInteger().findSmallestPositiveInt(input))
                .isEqualTo(expected);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 6, 4, 1, 2}, 5),
                Arguments.of(new int[]{1, 2, 3}, 4),
                Arguments.of(new int[]{-1, -3}, 1)
        );
    }

}