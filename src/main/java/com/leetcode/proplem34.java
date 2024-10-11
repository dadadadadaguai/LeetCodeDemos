package com.leetcode;

public class proplem34 {
  public static void main(String[] args) {
    int[] nums = {5, 7, 7, 7, 8, 8,10};
    int[] res = new proplem34().searchRange(nums, 8);
    System.out.println(res[0] + " " + res[1]);
  }

  public int[] searchRange(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    int first = -1; // 位置
    int last = -1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[mid] == target) {
        first = mid;
        right = mid - 1;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    left = 0;
    right = nums.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[mid] == target) {
        last = mid;
        left = mid + 1;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return new int[] {first, last};
  }
}
