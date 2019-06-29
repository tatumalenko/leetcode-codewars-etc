const assert = require('assert');
const { ListNode } = require('../modules/ds');

/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode[]} lists
 * @return {ListNode}
 */
function mergeKLists(lists) {
  const nLists = lists.length;
  let minIdx = 0;
  let minVal = Number.MAX_SAFE_INTEGER - 1;
  const head = new ListNode(-1);
  let curr = head;

  while (minVal < Number.MAX_SAFE_INTEGER) {
    minVal = Number.MAX_SAFE_INTEGER;
    for (let i = 0; i < nLists; i += 1) {
      if (lists[i] !== null
          && lists[i] !== undefined
          && lists[i].val < minVal) {
        minIdx = i;
        minVal = lists[i].val;
      }
    }
    if (minVal < Number.MAX_SAFE_INTEGER) {
      curr.next = lists[minIdx];
      lists[minIdx] = lists[minIdx].next;
      curr = curr.next;
    }
  }

  return head.next;
}

// var mergeKLists = function(lists) {
//     return merge(lists, 0, lists.length - 1);
// };

// function merge (lists, start, end) {
//     if (start > end) return null;
//     if (start === end) return lists[start];
//     if (start + 1 === end) return mergeTwoSortedLists(lists[start], lists[end]);
//     let mid = Math.floor((start + end) / 2);
//     let l1 = merge(lists, start, mid);
//     let l2 = merge(lists, mid + 1, end);
//     return mergeTwoSortedLists(l1, l2);
// }

// function mergeTwoSortedLists (l1, l2) {
//     let dummy = new ListNode(0);
//     let point = dummy;
//     while(l1 !== null && l2 !== null) {
//         if (l1.val >= l2.val) {
//             point.next = l2;
//             l2 = l2.next;
//         } else {
//             point.next = l1;
//             l1 = l1.next;
//         }
//         point = point.next;
//     }
//     if (l1 !== null) {
//         point.next = l1;
//     }
//     if (l2 !== null) {
//         point.next = l2;
//     }
//     return dummy.next;
// }

assert.equal(
  mergeKLists([ListNode.of([1, 4, 5]), ListNode.of([1, 3, 4]), ListNode.of([2, 6])])
    .equals(ListNode.of([1, 1, 2, 3, 4, 4, 5, 6])),
  true,
);
