package com.tatumalenko.algorithms.java.leetcode;

public class MaxConsecutiveOnes485 {

    public static int findMaxConsecutiveOnes(final int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int prevMax = 0;
        int newMax = nums[0] == 1 ? 1 : 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 1 && nums[i - 1] == 1) {
                newMax++;
            } else if (nums[i] == 1) {
                if (newMax > prevMax) {
                    prevMax = newMax;
                }
                newMax = 1;
            } else if (nums[i - 1] == 1) {
                if (newMax > prevMax) {
                    prevMax = newMax;
                }
                newMax = 0;
            }
        }
        return newMax > prevMax ? newMax : prevMax;
    }

}
