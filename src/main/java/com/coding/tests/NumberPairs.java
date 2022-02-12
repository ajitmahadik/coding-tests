package com.coding.tests;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberPairs {
    public static void main(String[] args) {
        int[] nums = {-10, -21, 14, 8, 97, 1, 5, 7, -1, 3, 3};
        findPairSumNearToZero(nums);
        findNumberOfPairsEqualToGivenSum(nums, 6);
    }

    private static void findNumberOfPairsEqualToGivenSum(int[] nums, int sum) {
        Map<Integer, Integer> pairs = new HashMap<>();
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            if (pairs.containsKey(sum - nums[i])) {
                count += pairs.get(sum - nums[i]);
            }
            if (pairs.containsKey(nums[i])) {
                pairs.put(nums[i], pairs.get(nums[i])+1);
            } else {
                pairs.put(nums[i], 1);
            }
        }
        System.out.println("Total pairs: "+count);
    }

    private static void findPairSumNearToZero(int[] nums) {
        int result = 0;
        int[] pair = new int[2];
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                int value = Math.abs(nums[i] + nums[j]);
                if (i==0 && j==1) {
                    result = value;
                } else {
                    if (result > value) {
                        result = value;
                        pair[0] = nums[i];
                        pair[1] = nums[j];
                    }
                }
            }
        }
        System.out.println(Arrays.toString(pair));
    }
}
