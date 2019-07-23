package com.tatumalenko.algorithms.codility.lesson5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Java6Assertions.assertThat;

class MinAvgTwoSliceTest {

    @ParameterizedTest
    @MethodSource("provider")
    void findMinAvgSlideFirstIndex(int[] input, int expected) {
        assertThat(new MinAvgTwoSlice().findMinAvgSlideFirstIndex(input))
                .isEqualTo(expected);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
//                Arguments.of(new int[]{4, 2, 2, 5, 1, 5, 8}, 1),
                Arguments.of(new int[]{10, 10, -1, 2, 4, -1, 2, -1}, 5)
        );
    }

}