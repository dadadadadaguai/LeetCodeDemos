package com.leetcode.easy;

import java.util.Arrays;

public class pro108 {
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

  public TreeNode sortedArrayToBST(int[] nums) {
    // 取中间节点
    int midIndex = getMidIndex(nums);
    TreeNode node = new TreeNode(nums[midIndex]);
    // if中间节点前面有元素，对其进行转化
    if (midIndex == 0) {
      // 截取取nums的1到nums.length部分
      node.left = sortedArrayToBST(Arrays.copyOfRange(nums, 1, nums.length - 1));
    } else if (midIndex == nums.length - 1) {
      node.right = sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length - 2));
    } else {
      node.left = sortedArrayToBST(Arrays.copyOfRange(nums, 1, nums.length - 1));
      node.right = sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length - 2));
    }
    return node;
  }

  private int getMidIndex(int[] nums) {
    return nums.length / 2;
  }

  private TreeNode sortedBST(int[] nums, int left, int right) {
    if (left >= right) {
      return null;
    }
    if (right - left == 1) {
      return new TreeNode(nums[left]);
    }
    int mid = left + (right - left) / 2;
    TreeNode mode = new TreeNode(nums[mid]);
    mode.left = sortedBST(nums, left, mid);
    mode.right = sortedBST(nums, mid + 1, right);
    return mode;
  }
}
