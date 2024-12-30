package com.leetcode.easy;

import java.util.ArrayList;

public class pro501 {
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

  ArrayList<Integer> res = new ArrayList<>();
  int maxCount = 0;
  int count = 0;
  TreeNode pre;

  public int[] findMode(TreeNode root) {
    travel(root);
    return res.stream().mapToInt(Integer::intValue).toArray();
  }

  private void travel(TreeNode root) {
    if (root == null) {
      return;
    }
    if (root.left != null) {
      travel(root.left);
    }
    if (pre == null || pre.val != root.val) {
      count = 1;
    } else {
      count++;
    }
    pre = root;
    if (count == maxCount) {
      res.add(root.val);
    } else if (count > maxCount) {
      res.clear();
      res.add(root.val);
      maxCount = count;
    }
    if (root.right != null) {
      travel(root.right);
    }
  }
}
