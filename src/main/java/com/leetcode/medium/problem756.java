package com.leetcode.medium;

/**
 * 使用最小花费爬楼梯
 */
public class problem756 {
    public int minCostClimbingStairs(int[] cost) {
        int len=cost.length;
        if(len<3){
            return Math.min(cost[0],cost[1]);
        }
        int[] dp=new int[len+1];
        for(int i=2;i<=len;i++){
            dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        for (int i : dp) {
            System.out.println(i);
        }
        return dp[len-1];
    }
    public  void test(){
        int[] input ={1,100,1,1,1,100,1,1,100,1};
        int[] input1 ={10,15,20};
        minCostClimbingStairs(input1);
    }
    public static void main(String[] args){
        new problem756().test();
    }
}
