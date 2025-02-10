package com.leetcode.medium;

/**
 * 62:不同路径
 *
 * @author dadaguai
 */
public class problem62 {
  public int uniquePaths(int m, int n) {
      int[][] dp= new int[m][n];
      dp[0][0]=1;
      for(int i=0;i<m;i++){
          for(int j=0;j<n;j++){
             //考虑边界
              if(i==0 ||j==0){
                  dp[i][j]=1;
              }else {
                  dp[i][j]=dp[i][j-1]+dp[i-1][j];
              }
          }
      }
      return dp[m-1][n-1];
  }
  public  void dataTest(){
      int result = uniquePaths(3, 2);
      System.out.println(result);
  }
    public static void main(String[] args){
        new problem62().dataTest();
    }
}

