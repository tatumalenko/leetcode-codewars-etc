package com.tatumalenko.algorithms.leetcode;

import com.tatumalenko.algorithms.datastructures.BinaryTreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.tatumalenko.algorithms.leetcode.FlattenBinaryTreeToLinkedList114.TreeNode;
import static org.assertj.core.api.Assertions.assertThat;

class FlattenBinaryTreeToLinkedList114Test {

    @ParameterizedTest
    @MethodSource("testProvider")
    void test(TreeNode input, TreeNode expected) {
        assertThat(new FlattenBinaryTreeToLinkedList114()
                .flatten(input).equals(expected))
                .isTrue();
    }

    private static Stream<Arguments> testProvider() {
        return Stream.of(
                Arguments.of(
                        new TreeNode(1,
                                new TreeNode(2,
                                        new TreeNode(3),
                                        new TreeNode(4)
                                ),
                                new TreeNode(5,
                                        new TreeNode(6),
                                        new TreeNode(7)
                                )
                        ),
                        new TreeNode(1,
                                null,
                                new TreeNode(2,
                                        null,
                                        new TreeNode(3,
                                                null,
                                                new TreeNode(4,
                                                        null,
                                                        new TreeNode(5,
                                                                null,
                                                                new TreeNode(6,
                                                                        null,
                                                                        new TreeNode(7)))))))));
    }

}
