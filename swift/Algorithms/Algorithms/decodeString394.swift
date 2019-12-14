//
//  decodeString394.swift
//  Algorithms
//
//  Created by Tatum Alenko on 2019-07-06.
//  Copyright © 2019 Tatum Alenko. All rights reserved.
//

import Foundation

class DecodeString394 {
    func decodeString(_ s: String) -> String {
        var nums: [String] = []
        var brackets: [String] = []
        let newIntEntry = true
        let newCharEntry = true
        
        for c in s {
            if Int(String(c)) != nil {
                if newIntEntry { nums.append(String(c)) }
                else {
                    nums[nums.endIndex] += String(c)
                }
            } else {
                // Is a character
                if newCharEntry {
                    if c == "]" {
                        if brackets.count == 0 {
                            
                        }
                    }
                } else {
                    brackets[brackets.endIndex] += String(c)
                }
            }
        }
        
        return ""
    }
}

func decodeString394() {
    assert(DecodeString394().decodeString("3[a]2[bc]") == "aaabcbc")
    assert(DecodeString394().decodeString("3[a2[c]]") == "accaccacc")
    assert(DecodeString394().decodeString("2[abc]3[cd]ef") == "abcabccdcdcdef")
}
