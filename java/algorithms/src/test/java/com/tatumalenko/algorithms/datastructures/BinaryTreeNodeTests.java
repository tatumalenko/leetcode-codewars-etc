package com.tatumalenko.algorithms.datastructures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryTreeNodeTests {

    @ParameterizedTest
    @MethodSource("testProvider")
    void ofTest(Integer[] input, TreeNode<Integer> expected) {
        TreeNode<Integer> actual = TreeNode.of(input);
        assertThat(actual.equals(expected))
                .isTrue();
    }

    private static Stream<Arguments> testProvider() {
        return Stream.of(
                Arguments.of(
                        new Integer[]{1, 2, 5, 3, 4, 6, 7},
                        new BinaryTreeNode<>(1,
                                new BinaryTreeNode<>(2,
                                        new BinaryTreeNode<>(3),
                                        new BinaryTreeNode<>(4)
                                ),
                                new BinaryTreeNode<>(5,
                                        new BinaryTreeNode<>(6),
                                        new BinaryTreeNode<>(7)
                                )
                        )),
                Arguments.of(
                        new Integer[]{1, null, 2, null, null, null, 3, null, null, null, null, null, null, null, 4,
                                null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                                null, 5,
                                null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                                null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                                null, null, null, 6,
                                null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                                null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                                null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                                null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                                null, null, null, null, null, null, null, 7},
                        new BinaryTreeNode<>(1,
                                null,
                                new BinaryTreeNode<>(2,
                                        null,
                                        new BinaryTreeNode<>(3,
                                                null,
                                                new BinaryTreeNode<>(4,
                                                        null,
                                                        new BinaryTreeNode<>(5,
                                                                null,
                                                                new BinaryTreeNode<>(6,
                                                                        null,
                                                                        new BinaryTreeNode<>(7)))))))
                )
        );
    }

}
