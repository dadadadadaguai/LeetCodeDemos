package com.leetcode.medium;

/**
 * problem343:整数拆分
 * @author 12086
 */
public class problem343 {
    public static int integerBreak(int n) {
        int[] dp= new int[n+1];
        dp[2]=1;
        for(int i=3;i<=n;i++){
            for (int j=1;j<=i/2;j++){
                dp[i]=Math.max(dp[i],Math.max((i-j)*j,dp[i-j]*j));
//        System.out.println(dp[i]);
            }
        }
//    System.out.println(Arrays.toString(dp));
        return dp[n];
    }
    public static void dataTest(){
        int n=2;
        int i = integerBreak(n);
    System.out.println(i);
    }
    public static void main(String[] args){
        dataTest();
    }
}
