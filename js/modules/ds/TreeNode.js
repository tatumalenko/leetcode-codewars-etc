class TreeNode {
  /**
   * Constructs a TreeNode with the given value.
   * @param {number} val
   */
  constructor(val) {
    this.val = val;
    this.left = null;
    this.right = null;
  }

  /**
   * Returns whether the two tree are structurally equal.
   * @param {TreeNode} other the TreeNode to compare with
   * @returns {boolean} whether both trees are equal
   */
  equals(other) {
    if (other == null) {
      return false;
    }

    const compare = (n1, n2) => {
      if (
        (n1 === null && n2 !== null)
          || (n1 !== null && n2 === null)
      ) {
        return false;
      } if (n1 !== null && n2 !== null) {
        return n1.val === n2.val
            && compare(n1.left, n2.left)
            && compare(n1.right, n2.right);
      }
      return true;
    };

    return compare(this, other);
  }

  /**
   * Returns the size of the longest branch in the tree.
   * @returns {number} the depth of the tree
   */
  depth() {
    // Iterative solution.
    const stack = [];
    let max = 0;
    stack.push(this);
    while (stack.length !== 0) {
      let size = stack.length;
      while (size > 0) {
        size -= 1;
        const node = stack.pop();
        if (node.left !== null) { stack.push(node.left); }
        if (node.right !== null) { stack.push(node.right); }
      }
      max += 1;
    }
    return max;

    // Recursive solution.
    // if (root === null) { return 0; }

    // return 1 + Math.max(
    //     maxDepthRecursive(root.left),
    //     maxDepthRecursive(root.right));
  }

  numberOfLeaves() {
    const numberOfLeavesRecursive = (root) => {
      // Base case.
      if (root === null) { return 0; }

      if (
        (root.left === null && root.right === null)
        || (root.left === undefined && root.right === undefined)
        || (root.left === undefined && root.right === null)
        || (root.left === null && root.right === undefined)
      ) {
        return 1;
      } if (root.left === null || root.left === undefined) {
        return numberOfLeavesRecursive(root.right);
      } if (root.right === null || root.right === undefined) {
        return numberOfLeavesRecursive(root.right);
      }
      return numberOfLeavesRecursive(root.left)
        + numberOfLeavesRecursive(root.right);
    };
    return numberOfLeavesRecursive(this.root);
  }

  /**
   * Builds a Binary Tree from an array
   * @param {number[]} array the array of numbers to built tree
   * @returns {TreeNode} the root node of the newly built tree
   */
  static of(array) {
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
  }
}

module.exports = TreeNode;
