package com.leetcode.medium;

public class pro105 {
 public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder.length == 0 || inorder.length == 0) {
      return null;
    }
    return buildHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
  }

  private TreeNode buildHelper(
      int[] preorder,
      int preorderStart,
      int preorderEnd,
      int[] inorder,
      int inorderStart,
      int inorderEnd) {
      if(preorderStart==preorderEnd){
          return null;
      }
      TreeNode treeNode = new TreeNode(preorder[preorderStart]);
      int nodeIndex;  //目标切割元素索引
      for(nodeIndex=0;nodeIndex<inorder.length;nodeIndex++){
          if (inorder[nodeIndex]==treeNode.val){
              break;
          }
      }
      //计算左右子树的中序区间索引
      int inorderLeftStart=inorderStart;
      int inorderLeftEnd=nodeIndex;
      int inorderRightStart=nodeIndex+1;
      int inorderRightEnd=inorderEnd;

      //计算左右子树的前序区间索引
      int preorderLeftStart=preorderStart+1;
      int preorderLeftEnd=preorderLeftStart+(inorderLeftEnd-inorderLeftStart);
      int preorderRightStart = preorderLeftEnd;
      int preorderRightEnd=preorderEnd;
      treeNode.left= buildHelper(preorder, preorderLeftStart, preorderLeftEnd, inorder, inorderLeftStart, inorderLeftEnd);
      treeNode.right=buildHelper(preorder, preorderRightStart, preorderRightEnd, inorder, inorderRightStart, inorderRightEnd);
      return treeNode;
  }
}
