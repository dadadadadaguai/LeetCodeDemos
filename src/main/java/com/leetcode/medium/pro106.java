package com.leetcode.medium;

public class pro106 {
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

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (inorder.length == 0 || postorder.length == 0) {
      return null;
    }
    return buildHelper(inorder, 0, inorder.length, postorder, 0, postorder.length);
  }

  private TreeNode buildHelper(
      int[] inorder,
      int inorderStart,
      int inOrderEnd,
      int[] postorder,
      int PostorderStart,
      int PostorderEnd) {
    if (PostorderStart == PostorderEnd) {
      return null;
    }
    TreeNode node = new TreeNode(postorder[PostorderEnd-1]);
    //计算中序的划分索引
    int rootIndex;
    for(rootIndex=0;rootIndex<inorder.length;rootIndex++){
      if (inorder[rootIndex]==node.val){
        break;
      }
    }
    //计算中序的区间索引
    int inorderLeftStart=inorderStart;
    int inorderLeftEnd=rootIndex;  //不包括划分索引
    int inorderRightStart=rootIndex+1;
    int inorderRightEnd =inOrderEnd;

    //计算后序的区间索引
    int postorderLeftStart=PostorderStart;
    int postorderLeftEnd = postorderLeftStart+(inorderLeftEnd-inorderLeftStart);
    int postorderRightStart=postorderLeftEnd;
    int postorderRightEnd=PostorderEnd-1;
    node.left = buildHelper(inorder, inorderLeftStart, inorderLeftEnd, postorder, postorderLeftStart, postorderLeftEnd);
    node.right = buildHelper(inorder, inorderRightStart, inorderRightEnd, postorder, postorderRightStart, postorderRightEnd);
    return node;
  }
}
