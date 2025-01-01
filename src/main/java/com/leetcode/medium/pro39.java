package com.leetcode.medium;

import java.util.*;

public class pro39 {
  List<List<Integer>> list = new ArrayList<>();
  LinkedList<Integer> path = new LinkedList<>();

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates); // 先进行排序
    selectNode(candidates, target, 0);
    return list;
  }

  private void selectNode(int[] candidates, int target, int startIndex) {
    if (target < 0) {
      return;
    }
    if (target == 0) {
      list.add(new ArrayList<>(path));
      return;
    }
    for (int i = startIndex; i < candidates.length; i++) {
      if (target < candidates[i]) {
        break;
      }
      path.add(candidates[i]);
      target -= candidates[i];
      selectNode(candidates, target, startIndex);
      target += candidates[i];
      path.removeLast();
    }
  }

  public static void main(String[] args) {
    pro39 p = new pro39();
    int[] candidates = {2, 3, 6, 7};
    int target = 7;
    List<List<Integer>> res = p.combinationSum(candidates, target);
    for (List<Integer> list : res) {
      for (int i : list) {
        System.out.print(i);
      }
      System.out.println();
    }
  }
}
