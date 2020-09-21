package com.tatumalenko.algorithms.java.codility.lesson1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryGapTest {

    @ParameterizedTest
    @MethodSource("provider")
    void solution(final int input, final int expected) {
        assertThat(BinaryGap.solution(input)).isEqualTo(expected);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
            Arguments.of(1041, 5),
            Arguments.of(15, 0),
            Arguments.of(32, 0),
            Arguments.of(1, 0),
            Arguments.of(5, 1),
            Arguments.of(6, 0),
            Arguments.of(66561, 9),
            Arguments.of(6291457, 20),
            Arguments.of(805306373, 25),
            Arguments.of(1073741825, 29)
        );
    }

}