//
//  findInMountainArray1095.cpp
//  Algorithms
//
//  Created by Tatum Alenko on 2019-07-03.
//  Copyright © 2019 Tatum Alenko. All rights reserved.
//

//#include <stdio.h>
#include <iostream>
#include <vector>
#include <cassert>
#include "Algorithm.hpp"
#include "Extern.h"

using namespace std;

/**
 * // This is the MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * class MountainArray {
 *   public:
 *     int get(int index);
 *     int length();
 * };
 */
MountainArray::MountainArray(vector<int> nums) {
    this->mountain = nums;
    this->getCtr = 0;
}
int MountainArray::get(int index) {
    this->getCtr++;
    return this->mountain.at((size_t)index);
}
int MountainArray::length() {
    return (int)mountain.size();
}

int FindInMountainArray1095::findInMountainArray(int target, MountainArray &mountainArr) {
    int start = 0;
    int end = mountainArr.length() - 1;
    
    if (mountainArr.get(start) == target) { return start; }
    
    // If target isn't even in range of bounds, don't bother looking.
    if (target < mountainArr.get(start) && target < mountainArr.get(end)) {
        return -1;
    }
    auto vec = vector<int>();
    search(target, mountainArr, start, end, vec);
    return vec.size() != 0 ? *std::min_element( std::begin(vec), std::end(vec) ) : -1;
}
void FindInMountainArray1095::search(int target, MountainArray &mountainArray, int start, int end, vector<int> &vec) {
    int startValue = start >= 0 ? mountainArray.get(start) : -1;
    int endValue = end <= mountainArray.length() ? mountainArray.get(end) : -1;
    
    // Base case 1 reached.
    if (startValue == target) {
        vec.push_back(start);
    }
    // Base case 2 reached.
    if (start == end) {
        return;
    }
    // Base case 3 reached.
    if (endValue == target) {
        vec.push_back(end);
    }
    
    int mid = (start + end) / 2;
    int midValue = mid != -1 ? mountainArray.get(mid) : -1;
    
    
    // Base case 4 reached.
    if (target == midValue) {
        vec.push_back(mid);
    }
    
    // We're at the top of mountain, target could be on either side.
    if (
        (startValue == -1 || startValue < midValue)
        && (endValue == -1 || endValue < midValue)
        ) {
        search(target, mountainArray, start, mid, vec);
        search(target, mountainArray, mid + 1, end, vec);
        return;
    }
    // We're increasing and target is on left side.
    if (target < midValue && ( (startValue != -1 && startValue < midValue) || (endValue != -1 && endValue > midValue) )) {
        search(target, mountainArray, start, mid, vec);
        return;
    }
    // We're increasing and target is on right side.
    if (target > midValue && ( (startValue != -1 && startValue < midValue) || (endValue != -1 && endValue > midValue) )) {
        search(target, mountainArray, mid + 1, end, vec);
        return;
    }
    // We're decreasing and target is on right side (i.e. towards lower number range).
    if (target < midValue && ( (startValue != -1 && startValue > midValue) || (endValue != -1 && endValue < midValue) )) {
        search(target, mountainArray, mid + 1, end, vec);
        return;
    }
    // We're decreasing and target is on left side (i.e. towards higher number range).
    if (target > midValue && ( (startValue != -1 && startValue > midValue) || (endValue != -1 && endValue < midValue) )) {
        search(target, mountainArray, start, mid, vec);
        return;
    }
    return;
}

int findInMountainArray1095() {
    MountainArray ma { vector<int>{ 1, 2, 3, 4, 5, 3, 1 } };
    assert(FindInMountainArray1095().findInMountainArray(3, ma) == 2);
    MountainArray ma2 { vector<int>{ 0, 1, 2, 4, 2, 1} };
    assert(FindInMountainArray1095().findInMountainArray(3, ma2) == -1);
    MountainArray ma3 { vector<int>{ 0, 1, 2, 4, 5, 6, 7, 8, 9, 11, 15, 17, 19, 22, 25, 45, 1} };
    assert(FindInMountainArray1095().findInMountainArray(3, ma3) == -1);
    assert(FindInMountainArray1095().findInMountainArray(45, ma3) == 15);
    MountainArray ma4 { vector<int>{ 1, 5, 2 } };
    assert(FindInMountainArray1095().findInMountainArray(1, ma4) == 0);
    MountainArray ma5 { vector<int>{ 1, 2, 3, 5, 3 } };
    assert(FindInMountainArray1095().findInMountainArray(3, ma5) == 2);
    MountainArray ma6 { vector<int>{ 1,6,11,16,21,26,31,36,41,46,51,56,61,66,71,76,81,86,91,96,101,106,111,116,121,126,131,136,141,146,151,156,161,166,171,176,181,186,191,196,201,206,211,216,221,226,231,236,241,246,251,256,261,266,271,276,281,286,291,296,301,306,311,316,321,326,331,336,341,346,351,356,361,366,371,376,381,386,391,396,401,406,411,416,421,426,431,436,441,446,451,456,461,466,471,476,481,486,491,496,501,496,491,486,481,476,471,466,461,456,451,446,441,436,431,426,421,416,411,406 } };
    assert(FindInMountainArray1095().findInMountainArray(481, ma6) == 96);
    MountainArray ma7 { vector<int>{ 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2 } };
    assert(FindInMountainArray1095().findInMountainArray(21, ma7) == 20);
    MountainArray ma8 { vector<int>{ 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,100,99,98,97,96,95,94,93,92,91,90,89,88,87,86,85,84,83,82 } };
    assert(FindInMountainArray1095().findInMountainArray(81, ma8) == 80);
    
    return 1;
}
