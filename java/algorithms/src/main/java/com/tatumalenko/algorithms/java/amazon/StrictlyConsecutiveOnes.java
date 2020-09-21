package com.tatumalenko.algorithms.java.amazon;

public class StrictlyConsecutiveOnes {

    public static boolean isConsecutiveOnes(final int[] nums) {
        int count = nums[0] == 1 ? 1 : 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 1 && nums[i - 1] == 1) {
                count++;
            } else if (nums[i] == 1) {
                if (count > 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
