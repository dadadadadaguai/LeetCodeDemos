package com.leetcode;

/**
 * problem63: 不同路径 II
 *
 * @author 12086
 */
public class problem63 {
  public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    int[][] dp = new int[m][n];
    for (int c = 0; c < m && obstacleGrid[c][0] == 0; c++) {
      dp[c][0] = 1;
    }
    for (int r = 0; r < n && obstacleGrid[0][r] == 0; r++) {
      dp[0][r] = 1;
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (obstacleGrid[i][j] == 1) {
          dp[i][j] = 0;
          continue;
        }
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }
    return dp[m - 1][n - 1];
  }

  public static void test() {
    int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
    int[][] obstacleGrid1 = {{0, 0}};
    System.out.println(uniquePathsWithObstacles(obstacleGrid1));
  }

  public static void main(String[] args) {
    test();
  }
}
