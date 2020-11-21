package com.tatumalenko.algorithms.kotlin.leetcode

import com.tatumalenko.algorithms.kotlin.ds.ListNode
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class ReverseLinkedList206Test {

    companion object {
        @JvmStatic
        fun arguments(): Stream<Arguments> = Stream.of(
            Arguments.of(
                ListNode.of(1, 2, 3, 4, 5),
                ListNode.of(5, 4, 3, 2, 1))
        )
    }

    @ParameterizedTest
    @MethodSource("arguments")
    fun test(input: ListNode?, expected: ListNode?) {
        assertEquals(expected, ReverseLinkedList206.reverseList(input))
    }

}
