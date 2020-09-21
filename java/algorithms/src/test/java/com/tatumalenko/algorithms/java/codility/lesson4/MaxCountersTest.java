package com.tatumalenko.algorithms.java.codility.lesson4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaxCountersTest {

    @ParameterizedTest
    @MethodSource("provider")
    void solution(final int N, final int[] A, final int[] B) {
        assertThat(MaxCounters.solution(N, A)).isEqualTo(B);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
            Arguments.of(5, new int[]{3, 4, 4, 6, 1, 4, 4}, new int[]{3, 2, 2, 4, 2})
        );
    }

}