//
//  largeSampleStatistics1093.swift
//  Algorithms
//
//  Created by Tatum Alenko on 2019-07-03.
//  Copyright © 2019 Tatum Alenko. All rights reserved.
//

import Foundation

class LargeSampleStatistics1093 {
    func sampleStats(_ count: [Int]) -> [Double] {
        var maxIdx = -1
        var maxValue = Int.min
        var firstNonZeroIdx = -1
        var lastNonZeroIdx = -1
        var sum = 0
        var frequency = 0
        
        let sampleSize = count.reduce(0, +)
        let sampleSizeIsEven = sampleSize % 2 == 0
        let medianIdx = sampleSizeIsEven ? sampleSize / 2 : sampleSize / 2 + 1
        var medianValue = 0.0
        
        for i in 0..<count.count {
            frequency += count[i]
            if frequency == medianIdx && sampleSizeIsEven {
                for j in (i+1)..<count.count {
                    if count[j] != 0 {
                        medianValue = Double(i + j) / 2
                        break
                    }
                }
                break
            } else if frequency > medianIdx {
                medianValue = Double(i)
                break
            }
        }
        
        for i in 0..<count.count {
            sum += i * count[i]
            if count[i] != 0 && firstNonZeroIdx == -1 {
                firstNonZeroIdx = i
            }
            if count[i] != 0 {
                lastNonZeroIdx = i
            }
            if count[i] > maxValue {
                maxValue = count[i]
                maxIdx = i
            }
        }
        
        return [Double(firstNonZeroIdx), Double(lastNonZeroIdx), Double(sum) / Double(sampleSize), medianValue, Double(maxIdx)]
    }
}

func largeSampleStatistics1093() {
    assert(LargeSampleStatistics1093().sampleStats([0,1,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]).elementsEqual([1.00000,3.00000,2.37500,2.50000,3.00000]))

//    assert(LargeSampleStatistics1093().sampleStats([0,4,3,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]).elementsEqual([1.00000,4.00000,2.18182,2.00000,1.00000]))
}
