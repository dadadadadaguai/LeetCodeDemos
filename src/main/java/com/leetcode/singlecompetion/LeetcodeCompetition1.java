package com.leetcode.singlecompetion;

// Alice 正在她的电脑上输入一个字符串。但是她打字技术比较笨拙，她 可能 在一个按键上按太久，导致一个字符被输入 多次 。
// 尽管 Alice 尽可能集中注意力，她仍然可能会犯错 至多 一次。
// 给你一个字符串 word ，它表示 最终 显示在 Alice 显示屏上的结果。
// 请你返回 Alice 一开始可能想要输入字符串的总方案数。
// 注意：竞赛中，请勿复制题面内容，以免影响您的竞赛成绩真实性。
class LeetcodeCompetition1 {
  public int possibleStringCount(String word) {
    int n = word.length();
    if (n == 1) return 1; // 只有一个字符时，只有一种可能
    char[] charArray = word.toCharArray();
    int len = charArray.length;
    int count = 1;
    for (int i = 0; i < len - 1; i++) {
      if (charArray[i] == charArray[i + 1]) {
        while (i + 1 < len && charArray[i] == charArray[i + 1]) {
          count++;
          i++;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    LeetcodeCompetition1 leetcodeCompetition1 = new LeetcodeCompetition1();
    System.out.println(leetcodeCompetition1.possibleStringCount("abbcccc"));
    System.out.println(leetcodeCompetition1.possibleStringCount("abcd"));
    System.out.println(leetcodeCompetition1.possibleStringCount("aaaa"));
    System.out.println(leetcodeCompetition1.possibleStringCount("eae"));
  }
}
