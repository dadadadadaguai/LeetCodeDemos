package com.leetcode.medium;

import lombok.Data;
import lombok.Getter;
import lombok.val;

@Data
public class TreeNode {
  Integer val;
  TreeNode right;
  TreeNode left;

  TreeNode() {}

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
