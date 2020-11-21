package com.tatumalenko.algorithms.kotlin.leetcode

import com.tatumalenko.algorithms.kotlin.ds.ListNode
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class AddTwoNumbers2Test {
    companion object {
        @JvmStatic
        fun arguments(): Stream<Arguments> = Stream.of(
            Arguments.of(ListNode.of(2, 4, 3), ListNode.of(5, 6, 4), ListNode.of(7, 0, 8)),
            Arguments.of(ListNode.of(0), ListNode.of(0), ListNode.of(0)),
            Arguments.of(ListNode.of(9, 9, 9, 9, 9, 9, 9), ListNode.of(9, 9, 9, 9), ListNode.of(8, 9, 9, 9, 0, 0, 0, 1))
        )
    }

    @ParameterizedTest(name = "{index} ==> given {0} and {1} return {1}")
    @MethodSource("arguments")
    fun test(l1: ListNode?, l2: ListNode?, expected: ListNode?) {
        assertEquals(expected, AddTwoNumbers2.addTwoNumbers(l1, l2))
    }
}
