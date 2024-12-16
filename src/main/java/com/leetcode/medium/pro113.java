package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class pro113 {
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

  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    ArrayList<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    ArrayList<Integer> nodeList = new ArrayList<>();
    setAllPath(root, targetSum, result, nodeList);
    return result;
  }

  private void setAllPath(
      TreeNode root, int targetSum, ArrayList<List<Integer>> result, ArrayList<Integer> path) {
    path.add(root.val);
    if (root.left == null && root.right == null) {
      if (targetSum == 0) {
        result.add(new ArrayList<>(path));
      } else {
        return;
      }
    }
    if (root.left != null) {
      setAllPath(root.left, targetSum - root.val, result,path);
      path.clear();
    }
    if (root.right != null) {
      setAllPath(root.right, targetSum - root.val, result,path);
      path.clear();
    }
  }
}
