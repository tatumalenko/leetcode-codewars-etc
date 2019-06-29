function maxPathLength(node) {
    if (!node) return 0;
    var leftHeight = maxPathLength(node.left);
    var rightHeight = maxPathLength(node.right);
    return Math.max(leftHeight, rightHeight) + 1;
}

const tree = {
    name: 'A',
    left: {
        name: 'B',
        left: null,
        right: null
    },
    right: {
        name: 'C',
        left: {
            name: 'D',
            left: null,
            right: null
        },
        right: {
            name: 'E',
            left: null,
            right: null
        }
    }
};

console.log(maxPathLength(tree));
