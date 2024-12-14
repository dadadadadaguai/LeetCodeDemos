package com.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class pro513 {
    class TreeNode {
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
    public int findBottomLeftValue(TreeNode root) {
//        if(root==null){
//            return 0;
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        int result = 0;
//        while(!queue.isEmpty()){
//            for(int i=0;i<queue.size();i++){
//                TreeNode node = queue.poll();
//                if(i==0){
//                    result=node.val;
//                }
//                if(node.left!=null){
//                    queue.offer(node.left);
//                }
//                if(root.right!=null){
//                    queue.offer(node.right);
//                }
//            }
//        }
//        return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (i == 0) {
                    res = poll.val;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return res;
    }
}
