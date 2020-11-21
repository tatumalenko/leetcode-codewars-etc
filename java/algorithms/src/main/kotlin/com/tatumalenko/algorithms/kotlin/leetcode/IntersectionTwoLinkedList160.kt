package com.tatumalenko.algorithms.kotlin.leetcode

import com.tatumalenko.algorithms.kotlin.ds.ListNode

object IntersectionTwoLinkedList160 {
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        var tempA = headA
        val setA = mutableSetOf<ListNode>()
        while (tempA != null) {
            setA.add(tempA)
            tempA = tempA.next
        }

        var tempB = headB
        while (tempB != null) {
            if (tempB in setA) {
                return tempB
            }
            tempB = tempB.next
        }

        return null
    }
}
