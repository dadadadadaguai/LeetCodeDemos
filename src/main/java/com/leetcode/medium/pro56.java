package com.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class pro56 {
  public int[][] merge(int[][] intervals) {
    LinkedList<int[]> list = new LinkedList<>();
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    int start = intervals[0][0];
    int end = intervals[0][1];
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] > end) {
        list.add(new int[] {start, end});
        start = intervals[i][0];
        end = intervals[i][1];
      } else {
        end = Math.max(end, intervals[i][1]);
      }
    }
    list.add(new int[] {start, end});
    return list.toArray(new int[list.size()][]);
  }
}
