package com.leetcode.medium;

import java.util.*;

public class pro77 {
  List<List<Integer>> list = new ArrayList<>();
  LinkedList<Integer> path = new LinkedList<>();

  public List<List<Integer>> combine(int n, int k) {
    addNew(n, k, 1);
    return list;
  }

  private void addNew(int n, int k, int startIndex) {
    if (path.size() == k) {
      list.add(new ArrayList<>(path));
      return;
    }
    for (int i = startIndex; i <= n; i++) {
      path.add(i);
      addNew(n, k, i + 1);
      path.removeLast();
    }
  }
}
