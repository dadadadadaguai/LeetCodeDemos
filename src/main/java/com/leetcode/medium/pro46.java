package com.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class pro46 {
  public List<List<Integer>> permute(int[] nums) {
    ArrayList<List<Integer>> lists = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used = new boolean[nums.length];
    com(lists, path, nums, used);
    return lists;
  }

  private void com(
      ArrayList<List<Integer>> lists, LinkedList<Integer> path, int[] nums, boolean[] used) {
    if (path.size() == nums.length) {
      lists.add(new ArrayList<>(path));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (used[i]) {
        continue;
      }
      path.add(nums[i]);
      used[i] = true;
      com(lists, path, nums, used);
      path.removeLast();
      used[i] = false;
    }
  }

  public static void main(String[] args) {
    pro46 p = new pro46();
    int[] nums = {1, 2, 3};
    System.out.println(p.permute(nums));
  }
}
