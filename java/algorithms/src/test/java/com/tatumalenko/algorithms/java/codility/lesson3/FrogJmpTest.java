package com.tatumalenko.algorithms.java.codility.lesson3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class FrogJmpTest {

    @ParameterizedTest
    @MethodSource("provider")
    void solution(final int X, final int Y, final int D, final int expected) {
        assertThat(FrogJmp.solution(X, Y, D)).isEqualTo(expected);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
            Arguments.of(10, 85, 30, 3),
            Arguments.of(10, 10, 30, 0)
        );
    }

}
