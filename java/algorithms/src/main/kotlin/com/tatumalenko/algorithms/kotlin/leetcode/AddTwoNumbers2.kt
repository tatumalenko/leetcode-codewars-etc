package com.tatumalenko.algorithms.kotlin.leetcode

import com.tatumalenko.algorithms.kotlin.ds.ListNode

object AddTwoNumbers2 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var current: ListNode?
        var recent: ListNode? = null
        var tip: ListNode? = null
        var a = l1
        var b = l2
        var leftover = 0
        while (a != null || b != null) {
            val nA = a?.`val` ?: 0
            val nB = b?.`val` ?: 0
            val sum = nA + nB + leftover
            if (sum > 9) {
                current = ListNode(sum - 10)
                leftover = 1
            } else {
                current = ListNode(sum)
                leftover = 0
            }
            if (tip == null) {
                tip = current
            }
            recent?.next = current
            recent = current
            a?.let { a = it.next }
            b?.let { b = it.next }
        }
        if (leftover > 0) {
            current = ListNode(leftover)
            recent?.next = current
        }
        return tip
    }
}
