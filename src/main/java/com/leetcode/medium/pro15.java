package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 三数之和
public class pro15 {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> list = new ArrayList<>();
    if (nums[0] > 0) {
      return list;
    }
    for (int i = 0; i < nums.length; i++) {
      int left = i + 1;
      int right = nums.length - 1;
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (sum > 0) {
          right--;
        } else if (sum < 0) {
          left++;
        } else {
          while (right > left && nums[left] == nums[left + 1]) {
            left++;
          }
          while (right > left && nums[right] == nums[right - 1]) {
            right--;
          }
          list.add(Arrays.asList(nums[i], nums[left], nums[right]));
          left++;
          right--;
        }
      }
    }
    return list;
  }

  public static void main(String[] args) {
    int[] nums = {-1, 0, 1, 2, -1, -4};
    System.out.println(new pro15().threeSum(nums));
  }
}
