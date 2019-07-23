package com.tatumalenko.algorithms.codility.lesson3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Java6Assertions.assertThat;

class MushroomPickerTest {

    @ParameterizedTest
    @MethodSource("provider")
    void findMaxMushrooms(int[] input, int k, int m, int expected) {
        assertThat(new MushroomPicker().findMaxMushrooms(input, k, m))
                .isEqualTo(expected);
    }

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 7, 5, 1, 3, 9}, 4, 6, 25)
        );
    }

}