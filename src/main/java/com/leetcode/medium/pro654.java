package com.leetcode.medium;

public class pro654 {
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructTree(nums,0,nums.length);
    }

    private TreeNode constructTree(int[] nums, int left, int right) {
        if (left>=right){
            return null;
        }
        //寻找最大值
        int maxValueIndex= left;
        for(int i=left+1;i<right;i++){
            if (nums[i]>nums[maxValueIndex]){
                maxValueIndex=i;
            }
        }
        TreeNode treeNode = new TreeNode(nums[maxValueIndex]);
        treeNode.left=constructTree(nums,left,maxValueIndex);
        treeNode.right=constructTree(nums,maxValueIndex+1,right);
        return treeNode;
    }
}
