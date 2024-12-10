package com.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class pro226 {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int len = queue.size();
      while (len > 0) {
        TreeNode node = queue.poll();
        nodeSwap(node);
        // 下一层入队
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
        len--;
      }
    }
    return root;
  }

  private void nodeSwap(TreeNode node) {
    TreeNode temp = node.left;
    node.left = node.right;
    node.right = temp;
  }
}
