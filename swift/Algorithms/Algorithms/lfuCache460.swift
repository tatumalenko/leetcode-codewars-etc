//
//  lfuCache460.swift
//  Algorithms
//
//  Created by Tatum Alenko on 2019-07-01.
//  Copyright © 2019 Tatum Alenko. All rights reserved.
//

import Foundation

class LFUCache {
    var capacity: Int
    var frequencyOrderItems: [LFUCacheItem?] = []
    var map: [Int: LFUCacheItem?]
    var insertionOrder: Int = 0
    var sortCompator: (LFUCacheItem?, LFUCacheItem?) -> Bool = { $0!.frequency == $1!.frequency
        ? $0!.insertionOrder < $1!.insertionOrder
        : $0!.frequency < $1!.frequency
    }
    
    init(_ capacity: Int) {
        self.capacity = capacity
        self.map = Dictionary<Int, LFUCacheItem>(minimumCapacity: capacity)
    }
    
    func get(_ key: Int) -> Int {
        if map[key] != nil {
            map[key]!!.frequency += 1
            insertionOrder += 1
            map[key]!!.insertionOrder = insertionOrder
            frequencyOrderItems.sort(by: sortCompator)
        }
        return map[key]??.value ?? -1
    }
    
    func put(_ key: Int, _ value: Int) {
        if capacity == 0 { return }
        if map[key] != nil {
            map[key]!!.value = value
            insertionOrder += 1
            map[key]!!.insertionOrder = insertionOrder
            map[key]!!.frequency += 1
            frequencyOrderItems.sort(by: sortCompator)
        } else if map.count < capacity {
            insertionOrder += 1
            map[key] = LFUCacheItem(key: key, value: value, insertionOrder: insertionOrder)
            frequencyOrderItems.append(map[key]!)
            frequencyOrderItems.sort(by: sortCompator)
        } else { // exists and no more capacity
            let node = frequencyOrderItems.removeFirst()
            map.remove(at: map.index(forKey: node!.key)!)
            insertionOrder += 1
            map[key] = LFUCacheItem(key: key, value: value, insertionOrder: insertionOrder)
            frequencyOrderItems.append(map[key]!)
            frequencyOrderItems.sort(by: sortCompator)
        }
    }
    
    class LFUCacheItem {
        var key: Int
        var value: Int
        var frequency = 0
        var insertionOrder: Int
        
        init(key: Int, value: Int, insertionOrder: Int) {
            self.key = key
            self.value = value
            self.insertionOrder = insertionOrder
        }
    }
}



// Your LFUCache object will be instantiated and called as such:
// let obj = LFUCache(capacity)
// let ret_1: Int = obj.get(key)
// obj.put(key, value)
func lfuCache460() {
    var cache: LFUCache
    
//    cache = LFUCache(2)
//    cache.put(1, 1)
//    cache.put(2, 2)
//    assert(cache.get(1) == 1)       // returns 1
//    cache.put(3, 3)                 // evicts key 2
//    assert(cache.get(2) == -1)      // returns -1 (not found)
//    assert(cache.get(3) == 3)       // returns 3.
//    cache.put(4, 4)                 // evicts key 1.
//    assert(cache.get(1) == -1)      // returns -1 (not found)
//    assert(cache.get(3) == 3)       // returns 3
//    assert(cache.get(4) == 4)       // returns 4
//
//    cache = LFUCache(2)
//    cache.put(2, 1)
//    cache.put(1, 1)
//    cache.put(1, 1)
//    cache.put(2, 3)                 // updates insertionOrder of key 2
//    cache.put(4, 1)                 // evicts key 1
//    assert(cache.get(1) == -1)
//    assert(cache.get(2) == 3)
    
    cache = LFUCache(10)
    doOperations(cache: cache,
                 inputs: [[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]],
                 expectedResults: [-1,19,17,-1,-1,-1,5,-1,12,3,5,5,1,-1,30,5,30,-1,-1,24,18,14,18,11,18,-1,4,29,30,12,11,29,17,-1,18,-1,20,29,18,18,20])
}

func doOperations(cache: LFUCache, inputs: [[Int]], expectedResults: [Int]) {
    var expectedResultsIdx = 0
    for op in inputs {
        if op.count == 1 {
            let actual = cache.get(op[0])
            let expected = expectedResults[expectedResultsIdx]
            assert(actual == expected)
            expectedResultsIdx += 1
        } else {
            cache.put(op[0], op[1])
        }
    }
}
