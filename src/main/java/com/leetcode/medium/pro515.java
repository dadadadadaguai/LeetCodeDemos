package com.leetcode.medium;

import lombok.val;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class pro515 {
  public List<Integer> largestValues(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) {
      return list;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    int max = Integer.MAX_VALUE;
    while (!queue.isEmpty()) {
      queue.offer(root);
      int len = queue.size();
      for (int i = 0; i < len; i++) {
        TreeNode node = queue.poll();
        max = Math.max(max, node.val);
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      list.add(max);
      max=Integer.MAX_VALUE;
    }
    return list;
  }
}
