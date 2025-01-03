package com.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class pro78 {
  List<List<Integer>> lists = new ArrayList<>();
  LinkedList<Integer> path = new LinkedList<>();

  public List<List<Integer>> subsets(int[] nums) {
    sub(nums, 0);
    lists.add(new ArrayList<>());
    return lists;
  }

  private void sub(int[] nums, int startindex) {
    for (int i = startindex; i < nums.length; i++) {
      path.add(nums[i]);
      lists.add(new ArrayList<>(path));
      sub(nums, i + 1);
      path.removeLast();
    }
  }

  public static void main(String[] args) {
    pro78 p = new pro78();
    int[] nums = {1, 2, 3};
    System.out.println(p.subsets(nums));
  }
}
