package com.leetcode.singlecompetion.competion432;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class proq1 {
  public List<Integer> zigzagTraversal(int[][] grid) {
    // 遍历grid
    ArrayList<Integer> list1 = new ArrayList<>();
    for (int i = 1; i <= grid.length; i++) {
      LinkedList<Integer> list2 = new LinkedList<>();
      for (int j = 1; j <= grid[0].length; j++) {
        if (i % 2 == 1 && j % 2 == 1) {
          list1.add(grid[i - 1][j - 1]);
        }
        if (i % 2 == 0 && j % 2 == 0) {
          list2.add(grid[i - 1][j - 1]);
        }
      }
      // 对链表list2翻转
      while (!list2.isEmpty()) {
        list1.add(list2.removeLast());
      }
    }
    return list1;
  }

  public static void main(String[] args) {
    proq1 p = new proq1();
    int[][] grid = {{1, 2, 1, 3}, {5, 15, 7, 3}, {10, 4, 14, 12}};
    System.out.println(p.zigzagTraversal(grid));
  }
}
