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
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
function mergeTwoLists(l1, l2) {
  if (l1 === null) {
    return l2;
  } if (l2 === null) {
    return l1;
  }

  let curr1 = l1;
  let curr2 = l2;
  const head = new ListNode(curr1.val < curr2.val ? curr1.val : curr2.val);
  let curr3 = head;

  if (curr1.val < curr2.val) {
    curr1 = curr1.next;
  } else {
    curr2 = curr2.next;
  }

  while (curr1 !== null || curr2 !== null) {
    if (curr1 === null) {
      curr3.next = curr2; // new ListNode(curr2.val);
      curr2 = curr2.next;
    } else if (curr2 === null) {
      curr3.next = curr1; // new ListNode(curr1.val);
      curr1 = curr1.next;
    } else {
      // new ListNode(curr1.val < curr2.val ? curr1.val : curr2.val);
      curr3.next = curr1.val < curr2.val ? curr1 : curr2;
      if (curr1.val < curr2.val) {
        curr1 = curr1.next;
      } else {
        curr2 = curr2.next;
      }
    }
    curr3 = curr3.next;
  }

  return head;
}

assert.equal(
  mergeTwoLists(ListNode.of([1, 2, 4]), ListNode.of([1, 3, 4]))
    .equals(ListNode.of([1, 1, 2, 3, 4, 4])), true,
);

assert.equal(
  mergeTwoLists(ListNode.of([1, 1, 2, 4]), null)
    .equals(ListNode.of([1, 1, 2, 4])), true,
);
