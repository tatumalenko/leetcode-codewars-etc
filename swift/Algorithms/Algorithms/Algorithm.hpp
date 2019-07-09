//
//  Algorithm.h
//  Algorithm
//
//  Created by Tatum Alenko on 2019-07-03.
//  Copyright © 2019 Tatum Alenko. All rights reserved.
//
#include <vector>

#ifndef Algorithm_h
#define Algorithm_h

class MountainArray {
private:
    std::vector<int> mountain;
    int getCtr;
public:
    MountainArray(std::vector<int> nums);
    int get(int index);
    int length();
};

class FindInMountainArray1095 {
public:
    int findInMountainArray(int target, MountainArray &mountainArr);
//    int findMountainIdx(MountainArray &mountainArray, int start, int end);
    void search(int target, MountainArray &mountainArray, int start, int end, std::vector<int> &vec);
};

#endif /* Algorithm_h */
