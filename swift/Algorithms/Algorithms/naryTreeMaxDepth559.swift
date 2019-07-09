//
//  naryTreeMaxDepth559.swift
//  Algorithms
//
//  Created by Tatum Alenko on 2019-07-01.
//  Copyright © 2019 Tatum Alenko. All rights reserved.
//

import Foundation

class NaryTreeMaxDepth559 {
    fileprivate static func maxDepth(_ root: TreeNode?) -> Int {
        if root == nil {
            return 0
        }
        var max = 0
        var curr: Int
        for node in (root?.children)! {
            curr = maxDepth(node)
            if curr > max { max = curr }
        }
        return 1 + max
    }
}

private class TreeNode {
    public var val: Int
    public var children: [TreeNode?]
    public init(_ val: Int) {
        self.val = val
        self.children = []
    }
    public init(value: Int, children: [TreeNode]) {
        self.val = value
        self.children = children
    }
}

func naryTreeMaxDepth559() {
    let root = TreeNode(value: 1, children: [
            TreeNode(value: 3, children: [
                    TreeNode(5),
                    TreeNode(6)
            ]),
            TreeNode(2),
            TreeNode(4)
    ])
    assert(NaryTreeMaxDepth559.maxDepth(root) == 3)
}
