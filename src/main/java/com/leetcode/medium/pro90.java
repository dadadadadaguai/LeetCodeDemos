package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class pro90 {
  List<List<Integer>> lists = new ArrayList<>();
  LinkedList<Integer> path = new LinkedList<>();

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    sub(nums, 0);
    return lists;
  }

  private void sub(int[] nums, int startIndex) {
    lists.add(new ArrayList<>(path));
    for (int i = startIndex; i < nums.length; i++) {
      if(i>startIndex && nums[i]==nums[i-1]){
        continue;
      }
      path.add(nums[i]);
      sub(nums, i + 1);
      path.removeLast();
    }
  }
  public static void main(String[] args){
    pro90 p = new pro90();
    int[] nums = {1,2,2};
    System.out.println(p.subsetsWithDup(nums));
  }
}
