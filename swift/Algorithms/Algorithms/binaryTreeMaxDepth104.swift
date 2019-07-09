//
//  binaryTreeMaxDepth104.swift
//  Algorithms
//
//  Created by Tatum Alenko on 2019-07-01.
//  Copyright © 2019 Tatum Alenko. All rights reserved.
//

import Foundation

class BinaryTreeMaxDepth104 {
    fileprivate static func maxDepth(_ root: TreeNode?) -> Int {
        if root == nil {
            return 0
        }
        return 1 + max(maxDepth(root?.left), maxDepth(root?.right))
    }
}

private class TreeNode {
    public var val: Int
    public var left: TreeNode?
    public var right: TreeNode?
    public init(_ val: Int) {
        self.val = val
        self.left = nil
        self.right = nil
    }
    static func build(from array: [Int?]) -> TreeNode? {
        var nodes: [TreeNode?] = []
        for i in 0..<array.count {
            nodes.append(array[i] != nil ? TreeNode(array[i]!) : nil)
        }
        var node: TreeNode?;
        for i in 0..<array.count {
            node = nodes[i]
            if node != nil {
                node!.left = 2 * i + 1 < nodes.count ? nodes[2 * i + 1] : nil
                node!.right =  2 * i + 2 < nodes.count ? nodes[2 * i + 2] : nil
            }
        }
        return nodes[0]
    }
}

func binaryTreeMaxDepth104() {
    assert(BinaryTreeMaxDepth104.maxDepth(TreeNode.build(from: [3, 9, 20, nil, nil, 15, 7])) == 3)
}
