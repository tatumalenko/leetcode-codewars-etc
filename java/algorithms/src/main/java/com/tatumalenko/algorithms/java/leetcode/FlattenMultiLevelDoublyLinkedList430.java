package com.tatumalenko.algorithms.java.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class FlattenMultiLevelDoublyLinkedList430 {

    public static Node flatten(final Node head) {
        final Deque<Node> stack = new ArrayDeque<>();
        Node cur = head;
        while (cur != null) {
            if (cur.child != null) {
                if (cur.next != null) {
                    stack.addFirst(cur.next);
                }
                cur.next = cur.child;
                cur.next.prev = cur;
                cur.child = null;
            } else {
                if (cur.next == null) {
                    if (stack.size() == 0) {
                        break;
                    }
                    cur.next = stack.removeFirst();
                    cur.next.prev = cur;
                }
            }
            cur = cur.next;
        }
        return head;
    }

    static class Node {

        public int val;

        public Node prev;

        public Node next;

        public Node child;

        public Node() {
        }

        public Node(final int _val, final Node _prev, final Node _next, final Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }

    }

}
