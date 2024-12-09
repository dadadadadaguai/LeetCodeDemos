package com.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class pro114 {
  public int maxDepth(TreeNode root) {
    int depth = 0;
    if (root == null) {
      return depth;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      depth++;
      int len = queue.size();
      while (len > 0) {
        TreeNode node = queue.poll();
        if (node.right != null) {
          queue.offer(node.right);
        }
        if (node.left != null) {
          queue.offer(node.left);
        }
        len--;
      }
    }
    return depth;
  }
}
