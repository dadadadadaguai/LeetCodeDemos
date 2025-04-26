package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class pro347new {
  public int[] topKFrequent(int[] nums, int k) {
    int[] result = new int[k];
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      queue.add(new int[] {entry.getKey(), entry.getValue()});
    }
    for (int i = 0; i < k; i++) {
      result[i] = queue.poll()[0];
    }
    return result;
  }
}
