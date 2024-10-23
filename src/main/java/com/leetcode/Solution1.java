package com.leetcode;

import java.util.HashMap;

class Solution454 {
  public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
      HashMap<Integer, Integer> map = new HashMap<>();
      for (int i : nums1) {
          for (int j : nums2) {
              map.put(i+j,map.getOrDefault(i+j,0)+1);
          }
      }
      int count = 0;
      for (int i : nums3) {
          for (int j : nums4) {
              count+=map.getOrDefault(0 -i - j,0);
          }
      }
      return count;
  }
  public static void main(String[] args){
      Solution454 s = new Solution454();
      int[] nums1 = {1,2};
      int[] nums2 = {-2,-1};
      int[] nums3 = {-1,2};
      int[] nums4 = {0,2};
      System.out.println(s.fourSumCount(nums1,nums2,nums3,nums4));
  }
}
