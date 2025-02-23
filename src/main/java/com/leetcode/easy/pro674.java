package com.leetcode.easy;

import java.util.Arrays;

public class pro674 {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int result = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                result++;
                dp[i] = Math.max(dp[i-1]+1, result);
            } else {
                result = 1;
                dp[i] = dp[i-1];
            }
        }
        return dp[n - 1];
    }
    public static void main(String[] args){
        pro674 p = new pro674();
        int[] nums = {1,3,5,4,7};
        int lengthOfLCIS = p.findLengthOfLCIS(nums);
        System.out.println(lengthOfLCIS);
    }
}
