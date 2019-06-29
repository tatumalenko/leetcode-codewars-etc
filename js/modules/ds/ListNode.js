const assert = require('assert');

class ListNode {
  constructor(value, next = null) {
    if (!value) { throw new Error('Must initialize with value.'); }
    this.val = value;
    this.next = next;
  }

  toArray() {
    const array = [];
    let that = this;
    while (that !== null) {
      array.push(that.val);
      that = that.next;
    }
    return array;
  }

  equals(other) {
    let curr1 = this;
    let curr2 = other;
    while (curr1 !== null || curr2 !== null) {
      if (curr1.val !== curr2.val) {
        // throw new Error('Not equal!');
        return false;
      }

      curr1 = curr1.next;
      curr2 = curr2.next;
    }

    if (curr1 !== null || curr2 !== null) {
      // throw new Error('Different sizes!');
      return false;
    }

    return true;
  }

  static of(array) {
    let head;
    let curr;
    for (let i = 0; i < array.length; i += 1) {
      if (i === 0) {
        head = new ListNode(array[i]);
        curr = head;
      } else {
        curr.next = new ListNode(array[i]);
        curr = curr.next;
      }
    }
    return head;
  }
}

const l1 = ListNode.of([1, 2, 4]);
const l2 = ListNode.of([1, 3, 4]);
// assert.doesNotThrow(() => l1.equals(l1), 'Shouldn\'t throw');
assert.equal(l1.equals(l1), true);
assert.equal(l1.equals(l2), false);
// assert.throws(() => l1.equals(l2), 'Does not throw "not equal"');

module.exports = ListNode;
