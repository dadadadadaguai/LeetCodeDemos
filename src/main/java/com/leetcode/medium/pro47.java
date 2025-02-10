package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class pro47 {
  public List<List<Integer>> permuteUnique(int[] nums) {
    ArrayList<List<Integer>> lists = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used = new boolean[nums.length];
    Arrays.sort(nums);
    per(lists, path, nums, used);
    return lists;
  }

  private void per(
      ArrayList<List<Integer>> lists, LinkedList<Integer> path, int[] nums, boolean[] used) {
    if (nums.length == path.size()) {
      lists.add(new ArrayList<>(path));
    }
    for (int i = 0; i < nums.length; i++) {
      if (used[i]) {
        continue;
      }
      if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
        continue;
      }
      used[i] = true;
      path.add(nums[i]);
      per(lists, path, nums, used);
      path.removeLast();
      used[i] = false;
    }
  }
  public static void main(String[] args){
    pro47 p = new pro47();
    int[] nums = {1,1,2};
    System.out.println(p.permuteUnique(nums));
  }
}
