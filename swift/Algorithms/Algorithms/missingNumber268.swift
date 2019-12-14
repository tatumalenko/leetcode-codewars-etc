//
//  missingNumber268.swift
//  Algorithms
//
//  Created by Tatum Alenko on 2019-10-14.
//  Copyright © 2019 Tatum Alenko. All rights reserved.
//

import Foundation

func missingNumber(_ nums: [Int]) -> Int {
    var arr = Array(repeating: 0, count: nums.count + 1)
    for i in nums {
        arr[i] = 1
    }
    for i in 0..<arr.count {
        if arr[i] == 0 {
            return i
        }
    }
    return -1
}
