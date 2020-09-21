package com.tatumalenko.algorithms.java.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BuilderExampleTest {

    @Test
    void test() {
        final BuilderExample builderExample = BuilderExample.builder()
            .a("a")
            .b("b")
            .c("c")
            .build();

        assertThat(builderExample.toString()).isEqualTo("abc");
    }

}