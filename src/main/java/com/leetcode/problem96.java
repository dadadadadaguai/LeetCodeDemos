package com.leetcode;

/**
 * problem96: 不同的二叉搜索树
 *
 * @author 12086
 */
public class problem96 {
    public static int numTrees(int n) {
        int [] dp = new int[n + 1];
        dp[0]=1;
        for (int i=1;i<=n;i++){
            for (int j=0;j<i;j++){
                dp[i]+=dp[i-j-1]*dp[j];
//        System.out.println(dp[i]);
            }
        }
        return  dp[n];
    }

    public static void test(){
        numTrees(3);
    }
    public static void main(String[] args){
        test();
    }
}
