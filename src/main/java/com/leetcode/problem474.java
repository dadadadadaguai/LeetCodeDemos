package com.leetcode;

/**
 * problem474: ones and zeroes
 */
public class problem474 {
  public int findMaxForm(String[] strs, int m, int n) {
    // 把0个个数和1的个数作为作为背包
    // 将一个字符的的0和1的个数作为物品，背包容量为m和n，求解最大价值
    int[][] dp = new int[m + 1][n + 1];
    // 遍历每个物品
    int zoerNum, oneNum;
    for (String str : strs) {
      zoerNum = 0;
      oneNum = 0;
      for (char c : str.toCharArray()) {
        if (c == '0') {
          zoerNum++;
        } else {
          oneNum++;
        }
      }
      // 遍历二维的重量
      for (int i = m; i >= zoerNum; i--) {
        for (int j = n; j >= oneNum; j--) {
          // dp[i][j]代表容量为i和j的情况下，子集最大的长度
          dp[i][j] = Math.max(dp[i - zoerNum][j - oneNum]+1, dp[i][j]);
//          System.out.println(dp[i][j]);
        }
      }
    }
    return dp[m][n];
  }
  public static void main(String[] args) {
    problem474 p = new problem474();
    String[] strs = {"10", "0001", "111001", "1", "0"};
    int m = 5;
    int n = 3;
    System.out.println(p.findMaxForm(strs, m, n));
  }
}
