function longestUnivaluePath(root) {
    return new Tree(root).max;
}

const root = {
    val: 1,
    left: {
        val: 4,
        left: {
            val: 4,
            left: null,
            right: null
        },
        right: {
            val: 4,
            left: null,
            right: null
        }
    },
    right: {
        val: 5,
        left: {
            val: 5,
            left: null,
            right: null
        },
        right: null
    }
};

class Tree {
    constructor(root) {
        this.max = 0;
        this.root = root;
        this.maxUnivaluePathHelper(root);
    }

    maxUnivaluePathHelper(node) {
        if (!node) return 0;

        const left = this.maxUnivaluePathHelper(node.left);
        const right = this.maxUnivaluePathHelper(node.right);

        const leftHeight =
            node.left && node.val === node.left.val ? left + 1 : 0;

        const rightHeight =
            node.right && node.val === node.right.val ? right + 1 : 0;

        this.max = Math.max(this.max, leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight);
    }
}

// function completeTreeFromArray(nodes) {
//     let tree = {};

//     for (let i = 0; i < nodes.length; i++) {
//         if (i ===)
//     }
// }

console.log(longestUnivaluePath(root));
