package com.tatumalenko.algorithms.util;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Set;

import static org.assertj.core.api.Java6Assertions.assertThat;

class StackTraceUtilsTest {

    private Set<Method> stackTraceUtilsTestMethods =
            Set.of(getClass().getDeclaredMethods());

    @Test
    void test(TestInfo testInfo) {
//        StackTraceUtils.setStackTraceSupplier();
        Set<Method> methods = StackTraceUtils.getMethods(StackTraceUtilsTest.class,
                StackTraceUtils.withAnnotations(
                        Test.class
                ));
        assertThat(methods).contains(testInfo.getTestMethod().orElse(null));

        methods = StackTraceUtils.getMethods(StackTraceUtilsTest.class);
        assertThat(methods).containsAll(stackTraceUtilsTestMethods);

        methods = StackTraceUtils.getMethods(StackTraceUtilsTest.class,
                StackTraceUtils.withAnnotations(
                        RepeatedTest.class
                ));
        assertThat(methods).contains(stackTraceUtilsTestMethods.stream()
                .filter(e -> e.getName().equals("repeatedTest")).findFirst().orElse(null));
    }

    @Test
    void getStackTraceMethodsTest(TestInfo testInfo) {
        Set<Method> methods = StackTraceUtils.getStackTraceMethods(
                StackTraceUtils.withAnnotations(
                        Test.class
                ));
        assertThat(methods).containsExactly(testInfo.getTestMethod().orElse(null));
    }

    @RepeatedTest(3)
    void repeatedTest() {
        // nothing.
    }

    static class Annotations {

        @Retention(RetentionPolicy.RUNTIME)
        @Target(ElementType.METHOD)
        @interface A {
        }

        @Retention(RetentionPolicy.RUNTIME)
        @Target(ElementType.METHOD)
        @interface B {
        }

        @Retention(RetentionPolicy.RUNTIME)
        @Target(ElementType.METHOD)
        @interface C {
        }
    }

    static class AnnotationTest {

        @Annotations.A
        void methodA() {
        }

        @Annotations.A
        @Annotations.B
        void methodAB() {
        }

        @Annotations.A
        @Annotations.B
        @Annotations.C
        void methodsABC() {
        }

    }

}