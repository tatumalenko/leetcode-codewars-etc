const assert = require('assert');

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} L
 * @param {number} R
 * @return {number}
 */
function rangeSumBst(root, L, R) {
  let sum = 0;
  const stack = [];
  stack.push(root);
  while (stack.length !== 0) {
    const node = stack.pop();
    if (node !== null) {
      if (L <= node.val && node.val <= R) {
        sum += node.val;
      }
      if (L < node.val) {
        stack.push(node.left);
      }
      if (R > node.val) {
        stack.push(node.right);
      }
    }
  }
  return sum;
}

/**
 * Solution using recursion within a closure.
 * // const rangeSumBst = function(root, L, R) {
 * //     let sum = 0;
 * //     const incrementSumIfInRange = (node, L, R) => {
 * //         if (node === null) {
 * //             return;
 * //         } else {
 * //             if (node.val >= L && node.val <= R) {
 * //                 sum += node.val;
 * //             }
 * //             if (node.left === null && node.right === null) {
 * //                 return;
 * //             } else if (node.left === null) {
 * //                 incrementSumIfInRange(node.right, L, R);
 * //             } else if (node.right === null) {
 * //                 incrementSumIfInRange(node.left, L, R);
 * //             } else {
 * //                 incrementSumIfInRange(node.left, L, R);
 * //                 incrementSumIfInRange(node.right, L, R);
 * //             }
 * //         }
 * //     };
 * //     incrementSumIfInRange(root, L, R);
 * //     return sum;
 * // };
 * /**
 * Solution using recursion.
 */
/*
 * Const rangeSumBst = function(root, L, R) {
 *     if (root === null) {
 *         return 0;
 *     }
 */

/*
 *     If (root.val > R) {
 *         return rangeSumBst(root.left, L, R);
 *     } else if (root.val < L) {
 *         return rangeSumBst(root.right, L, R);
 *     } else {
 *         return root.val + rangeSumBst(root.left, L, R) + rangeSumBst(root.right, L, R);
 *     }
 * };
 */

function TreeNode(val) {
  this.val = val;
  this.left = null;
  this.right = null;
}

TreeNode.prototype.equals = function equals(other) {
  if (other == null) {
    return false;
  }

  const compare = (n1, n2) => {
    if (n1 === null && n2 !== null || n1 !== null && n2 === null) {
      return false;
    } if (n1 !== null && n2 !== null) {
      return n1.val === n2.val
                && compare(n1.left, n2.left)
                && compare(n1.right, n2.right);
    } // Both null
    return true;
  };

  return compare(this, other);
};

TreeNode.of = function of(array) {
  const nodes = [];
  for (let i = 0; i < array.length; i += 1) {
    nodes.push(array[i] !== null ? new TreeNode(array[i]) : null);
  }

  let node;
  for (let i = 0; i < array.length; i += 1) {
    node = nodes[i];
    if (node !== null) {
      node.left = 2 * i + 1 < nodes.length ? nodes[2 * i + 1] : null;
      node.right = 2 * i + 2 < nodes.length ? nodes[2 * i + 2] : null;
    }
  }

  return nodes[0];
};

/*
 * Debug print the TreeNode.of() and rangeSumBst() methods.
 * console.log(TreeNode.of([10, 5, 15, 3, 7, null, 18]));
 * console.log(rangeSumBst(TreeNode.of([10, 5, 15, 3, 7, null, 18]), 7, 15));
 */

// Test the equals() method which will help test TreeNode.of() as well.
assert(
  TreeNode.of([10, 5, 15, 3, 7, null, 18])
    .equals(TreeNode.of([10, 5, 15, 3, 7, null, 18])) === true,
);
assert(
  TreeNode.of([10, 5, 15, 3, 7, null, 18])
    .equals(TreeNode.of([10, 5, 1, 3, 7, null, 18])) === false,
);
assert(
  TreeNode.of([10, 5, 15, 3, 7, null])
    .equals(TreeNode.of([10, 5, 15, 3, 7, null, 18])) === false,
);
assert(
  TreeNode.of([10, 5, 15, 3, 7, null, 18])
    .equals(TreeNode.of([10, 5, 1, 3, 7, null, 18])) === false,
);
assert(
  TreeNode.of([0, 1, 4, 3, 7, null, 18])
    .equals(TreeNode.of([10, 5, 1, 3, 7, null, 18])) === false,
);
assert(TreeNode.of([1]).equals(TreeNode.of([1])) === true);
assert(TreeNode.of([1]).equals(TreeNode.of([3])) === false);

// Test cases for the problem at hand.
assert.equal(rangeSumBst(TreeNode.of([10, 5, 15, 3, 7, null, 18]), 7, 15), 32);
assert.equal(rangeSumBst(TreeNode.of([10, 5, 15, 3, 7, 13, 18, 1, null, 6]), 6, 10), 23);
