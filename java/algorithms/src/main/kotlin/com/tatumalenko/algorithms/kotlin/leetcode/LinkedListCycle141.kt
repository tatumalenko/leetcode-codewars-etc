package com.tatumalenko.algorithms.kotlin.leetcode

import com.tatumalenko.algorithms.kotlin.ds.ListNode

object LinkedListCycle141 {
    fun hasCycle(head: ListNode?): Boolean {
        var fast = head?.next?.next
        var slow = head?.next

        while (fast != null && slow != null) {
            if (fast === slow) {
                return true
            }
            fast = fast.next?.next
            slow = slow.next
        }

        return false
    }
}
