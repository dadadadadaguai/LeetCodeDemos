package com.leetcode.medium;

import java.util.*;

public class pro491 {
  public List<List<Integer>> findSubsequences(int[] nums) {
    ArrayList<List<Integer>> lists = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    find(lists, path, nums, 0);
    return lists;
  }

  private void find(
      ArrayList<List<Integer>> lists, LinkedList<Integer> path, int[] nums, int startIndex) {
    if (path.size() > 1) {
      lists.add(new ArrayList<>(path));
    }
    HashSet<Integer> set = new HashSet<>();
    for (int i = startIndex; i < nums.length; i++) {
      if (path.size() > 0 && nums[i] < path.getLast()) {
        continue;
      }
      if (i > startIndex && set.contains(nums[i])) {
        continue;
      }
      path.add(nums[i]);
      set.add(nums[i]);
      find(lists, path, nums, i + 1);
      path.removeLast();
    }
  }

  public static void main(String[] args) {
    pro491 p = new pro491();
    int[] nums = {1, 2, 3, 1, 1, 1};
    List<List<Integer>> subsequences = p.findSubsequences(nums);
    for (List<Integer> list : subsequences) {
      for (int i : list) {
        System.out.print(i);
      }
      System.out.println();
    }
  }
}
