package com.leetcode.medium;

import java.util.*;

public class pro40 {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    ArrayList<List<Integer>> lists = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    Arrays.sort(candidates);
    //    boolean[] used = new boolean[candidates.length];
    combin(lists, path, candidates, target, 0);
    return lists;
  }

  private void combin(
      ArrayList<List<Integer>> lists,
      LinkedList<Integer> path,
      int[] candidates,
      int target,
      int start) {
    if (target < 0) {
      return;
    }
    if (target == 0) {
      lists.add(new ArrayList<>(path));
      return;
    }
    for (int i = start; i < candidates.length; i++) {
      if (target < candidates[i]) {
        continue;
      }
      if (i > start && candidates[i] == candidates[i - 1]) {
        continue;
      }
      path.add(candidates[i]);
      combin(lists, path, candidates, target - candidates[i], i + 1);
      path.removeLast();
    }
  }

  public static void main(String[] args) {
    pro40 p = new pro40();
    int[] candidates = {10, 1, 2, 7, 6, 1, 5};
    int target = 8;
    List<List<Integer>> res = p.combinationSum2(candidates, target);
    for (List<Integer> list : res) {
      for (int i : list) {
        System.out.print(i);
      }
      System.out.println();
    }
  }
}
