package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class problem18 {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> list = new ArrayList<>();
//    if (nums[0] > target) {
//      return list;
//    }
    for (int i = 0; i < nums.length; i++) {
      // 剪枝处理
      if (nums[i] > target && nums[i] >= 0) {
        break;
      }
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] > target && nums[i] + nums[j] > 0) {
          break;
        }
        if (j > i + 1 && nums[j] == nums[j - 1]) {
          continue;
        }
        int left = j + 1;
        int right = nums.length - 1;
        while (left < right) {
          int sum = nums[i] + nums[j] + nums[left] + nums[right];
          if (sum < target) {
            left++;
          } else if (sum > target) {
            right--;
          } else {
            while (left < right && nums[left] == nums[left + 1]) {
              left++;
            }
            while (left < right && nums[right] == nums[right - 1]) {
              right--;
            }
            list.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
            left++;
            right--;
          }
        }
      }
    }
    return list;
  }

  public static void main(String[] args) {
    problem18 p = new problem18();
    int[] nums = {1, 0, -1, 0, -2, 2};
    int[] nums1 = {2, 2, 2, 2};
        System.out.println(p.fourSum(nums, 0));
    System.out.println(p.fourSum(nums1, 8));
  }
}
