const assert = require('assert');

const { TreeNode, List } = require('../modules/ds');

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * Given a binary tree, find its maximum depth.
 * @param {TreeNode} root
 * @return {number}
 */
function maxDepthOfBinaryTree(root) {
  // return maxDepthRecursive(root);
  return maxDepthIterative(root);
}

// function numberOfLeaves(root) {
//     // Base case.
//     if (root === null) { return 0; }

//     if (root.left === null && root.right === null) {
//         return 1;
//     } else if (root.left === null) {
//         return maxDepthRecursive(root.right);
//     } else if (root.right === null) {
//         return maxDepthRecursive(root.right);
//     } else {
//         return maxDepthRecursive(root.left) + maxDepthRecursive(root.right);
//     }
// }

// function maxDepthRecursive(root) {
//   if (root === null) { return 0; }

//   return 1 + Math.max(
//     maxDepthRecursive(root.left),
//     maxDepthRecursive(root.right),
//   );
// }

function maxDepthIterative(root) {
  if (root === null) { return 0; }
  const queue = new List();
  queue.offer(root);
  let max = 0;
  while (!queue.isEmpty()) {
    let size = queue.size();
    while (size > 0) {
      size -= 1;
      const node = queue.poll();
      if (node.left !== null && node.left !== undefined) { queue.offer(node.left); }
      if (node.right !== null && node.right !== undefined) { queue.offer(node.right); }
    }
    max += 1;
  }
  return max;
}

assert.equal(maxDepthOfBinaryTree(TreeNode.of([3, 9, 20, null, null, 15, 7])), 3);
