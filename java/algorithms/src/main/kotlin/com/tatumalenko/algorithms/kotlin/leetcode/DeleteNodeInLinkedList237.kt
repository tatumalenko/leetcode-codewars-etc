package com.tatumalenko.algorithms.kotlin.leetcode

import com.tatumalenko.algorithms.kotlin.ds.ListNode

object DeleteNodeInLinkedList237 {
    fun deleteNode(node: ListNode?) {
        node?.next?.let {
            node.`val` = it.`val`
            node.next = it.next
        }
    }
}
