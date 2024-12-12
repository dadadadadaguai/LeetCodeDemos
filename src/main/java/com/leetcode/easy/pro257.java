package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class pro257 {
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

  public List<String> binaryTreePaths(TreeNode root) {
    ArrayList<String> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    ArrayList<Integer> nodeList = new ArrayList<>();
    setPath(root, nodeList, result);
    return result;
  }

  // 获取根节点到叶子节点的路径
  private void setPath(TreeNode root, ArrayList<Integer> nodeList, ArrayList<String> result) {
    nodeList.add(root.val);
    if (root.left == null && root.right == null) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < nodeList.size() - 1; i++) {
        sb.append(nodeList.get(i)).append("->");
      }
      sb.append(nodeList.get(nodeList.size() - 1));
      result.add(sb.toString());
    }
    if (root.left != null) {
      setPath(root.left, nodeList, result);
      // 这里会把root.left节点添加到原本的path中,回溯需要删除
      nodeList.remove(nodeList.size() - 1);
    }
    if (root.right != null) {
      setPath(root.right, nodeList, result);
      // 这里会把root.left节点添加到原本的path中,回溯需要删除
      nodeList.remove(nodeList.size() - 1);
    }
  }
}
