package com.leetcode;

/**
 * problem416: 分割等和子集
 */
public class problem416 {
  public boolean canPartition(int[] nums) {
    int len = nums.length;
    // 对nums递增排序
    if (len < 1) {
      return false;
    }
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (sum % 2 != 0) {
      return false;
    }
    int[] dp = new int[sum + 1];
    int target = sum / 2;
    for (int i = 0; i < len; i++) {
      for (int j = target; j >= nums[i]; j--) {
        dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
      }
      if (dp[target] == target) {
        return true;
      }
    }
    return dp[target] == target;
  }

  public static void test() {
    int[] nums = {1, 1, 2, 3, 3, 4};
    System.out.println(new problem416().canPartition(nums));
  }

  public static void main(String[] args) {
    test();
  }
}
