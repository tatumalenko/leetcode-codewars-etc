package com.tatumalenko.algorithms.google;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Question2Test {

    Question2 question2 = new Question2();

    @Test
    void solution() {
        assertThat(question2.solution("abcd,aabc,bd", "aaa,aa"))
                .isEqualTo(new int[]{3, 2});
    }

    @Test
    void solution3() {
        assertThat(question2.solution("abcd,aabc,bd,z", "aaa,aa,xyz"))
                .isEqualTo(new int[]{4, 3,});
    }

    @Test
    void solution4() {
        assertThat(question2.solution("bbbd,abbc,ddb,bd", "abc,aab,bbd"))
                .isEqualTo(new int[]{0, 3, 3});
    }

    @Test
    void solution5() {
        assertThat(question2.solution("a", "a"))
                .isEqualTo(new int[]{0, 3, 3});
    }
}