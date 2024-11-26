package com.leetcode.hard;

import java.util.*;

public class pro239 {
  public int[] maxSlidingWindow(int[] nums, int k) {
    // 创建一个双端队列
    Deque<Integer> queue = new LinkedList<>();
    ArrayList<Integer> res = new ArrayList<>();
    int max = Integer.MIN_VALUE;
    for (int j = 0; j < Math.min(k, nums.length); j++) {
      queue.addLast(nums[j]);
      max = Math.max(max, nums[j]);
    }
    if ((k == nums.length)) {
      // 返回nums的最大值
      return new int[] {ComputeMax(queue)};
    }
    res.add(max);
    for (int i = k; i < nums.length; i++) {
      queue.removeFirst();
      queue.addLast(nums[i]);
      res.add(ComputeMax(queue));
    }
    return res.stream().mapToInt(Integer::valueOf).toArray();
  }

  private Integer ComputeMax(Deque<Integer> queue) {
    return queue.stream().max(Integer::compareTo).get();
  }

  public static void main(String[] args) {
    pro239 p = new pro239();
    //    int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
    int[] nums = {9, 11};
    int[] res = p.maxSlidingWindow(nums, 2);
    for (int i : res) {
      // 不换行打印
      System.out.print(i);
    }
  }
}
