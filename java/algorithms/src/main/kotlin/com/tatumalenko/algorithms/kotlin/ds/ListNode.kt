package com.tatumalenko.algorithms.kotlin.ds

data class ListNode(var `val`: Int, var next: ListNode? = null) {
    companion object {
        fun of(array: IntArray): ListNode? {
            val head = if (array.isNotEmpty()) ListNode(array[0]) else null
            var node = head
            for (element in array.slice(1 until array.size)) {
                node?.next = ListNode(element)
                node = node?.next
            }
            return head
        }
    }
}
