package com.leetcode.medium;

import java.util.*;

public class pro216 {
  HashSet<List<Integer>> set = new HashSet<>();
  LinkedList<Integer> path = new LinkedList<>();

  public List<List<Integer>> combinationSum3(int k, int n) {
    com(k, n, 1);
    return new ArrayList<>(set);
  }

  private void com(int k, int n, int startIndex) {
    if (n == 0 && path.size() == k) {
      set.add(new ArrayList<>(path));
      return;
    }
    for (int i = startIndex; i <= 9; i++) {
      path.add(i);
      com(k, n - i, i+1);
      path.removeLast();
    }
  }
  public static void main(String[] args) {
    pro216 p = new pro216();
    List<List<Integer>> lists = p.combinationSum3(3, 7);
    for (List<Integer> list : lists) {
      for (int i : list) {
        System.out.print(i);
      }
      System.out.println();
    }
  }
}
