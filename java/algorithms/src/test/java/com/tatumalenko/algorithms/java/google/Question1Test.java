package com.tatumalenko.algorithms.java.google;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Question1Test {

    Question1 question1 = new Question1();

    @Test
    void solution() {

        Question1.solution(new int[]{2, 4, 3, 1, 5}, 2);
    }

    @Test
    void findSubarray() {
        final Integer[] nums = new Integer[]{2, 4, 3, 1, 5};

        final Integer[] ans = Question1.findSubarray(nums, 2);

        assertThat(ans).isEqualTo(new Integer[]{4, 3});
    }

    @Test
    void findSubarray2() {
        final Integer[] nums = new Integer[]{2, 4, 3, 1, 5};

        final Integer[] ans = Question1.findSubarray(nums, 4);

        assertThat(ans).isEqualTo(new Integer[]{4, 3, 1, 5});
    }

    @Test
    void findSubarray3() {
        final Integer[] nums = new Integer[]{1, 4, 3, 2, 5};

        final Integer[] ans = Question1.findSubarray(nums, 2);

        assertThat(ans).isEqualTo(new Integer[]{4, 3});
    }

    @Test
    void findSubarray4() {
        final Integer[] nums = new Integer[]{4, 4, 3, 4, 5};

        final Integer[] ans = Question1.findSubarray(nums, 1);

        assertThat(ans).isEqualTo(new Integer[]{5});
    }

}