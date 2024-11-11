package com.leetcode.easy;

public class problem27 {
  public int removeElement(int[] nums, int val) {
    int i = 0;
    int j = nums.length -1;
    while (i <= j) {
      if (nums[i] == val) {
        nums[i]=nums[j--];
      } else {
        i++;
      }
    }
    return i;
  }

  public static void main(String[] args) {
    problem27 p = new problem27();
//    int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
    int[] nums = {2};
    int val = 2;
    System.out.println(p.removeElement(nums, val));
  }
}
