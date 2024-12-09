package com.leetcode.medium;

import java.util.*;

public class pro347 {
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : nums) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }
    //大根堆
    PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      queue.add(new int[] {entry.getKey(), entry.getValue()});
    }
    int[] res = new int[k];
    for (int i = 0; i < k; i++) {
      res[i] = queue.poll()[0];
    }
    return res;
  }

  public static void main(String[] args) {
    //    int[] nums = {1,2};
    int[] nums = {5, 3, 1, 1, 1, 3, 5, 73, 1};
    int k = 3;
    pro347 p = new pro347();
    int[] result = p.topKFrequent(nums, k);
    for (int i : result) {
      System.out.print(i + ",");
    }
  }
}
