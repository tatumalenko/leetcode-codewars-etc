package com.tatumalenko.algorithms.kotlin.leetcode

import com.tatumalenko.algorithms.kotlin.ds.ListNode

object ReverseLinkedList206 {
    fun reverseList(head: ListNode?): ListNode? {
        var node = head
        var prev: ListNode? = null
        while (node != null) {
            val tempNext = node.next
            node.next = prev
            prev = node
            node = tempNext
        }
        return prev
    }
}
