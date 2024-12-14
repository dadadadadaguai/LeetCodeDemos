package com.leetcode.easy;

import com.leetcode.medium.TreeNode;

public class pro12 {
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

  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) return false;
    int sum = 0;
    return getPathSum(root, sum, targetSum);
  }

  private Boolean getPathSum(TreeNode root, int sum, int targetSum) {
    sum += root.val;
    if (root.left == null && root.right == null && sum == targetSum) {
      return true;
    }
    if (root.left != null) {
      getPathSum(root.left, sum, targetSum - sum);
      sum -= root.left.val;
    }
    if (root.right != null) {
      if (!getPathSum(root.right, sum, targetSum - sum));
    }
    return false;
  }
}
