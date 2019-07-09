//
//  setMismatch645.swift
//  Algorithms
//
//  Created by Tatum Alenko on 2019-07-01.
//  Copyright © 2019 Tatum Alenko. All rights reserved.
//

import Foundation

func findErrorNums(_ nums: [Int]) -> [Int] {
    var result = Array(repeating: -1, count: 2)
    let sorted = nums.sorted()
    for idx in 1..<sorted.count {
        if sorted[idx] == sorted[idx - 1] {
            result[0] = sorted[idx]
            result[1] = sorted[idx - 2] == sorted[idx - 1] - 1 ? sorted[idx] + 1 : sorted[idx] - 1
            break
        }
    }
    return result
}

func setMismatch645() {
    assert(findErrorNums([1, 2 , 2, 4]) == [2, 3])
}
