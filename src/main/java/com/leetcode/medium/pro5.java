package com.leetcode.medium;

public class pro5 {
  public String longestPalindrome(String s) {
    char[] charArray = s.toCharArray();
    if (s.length() == 1) {
      return s;
    }
    String maxStr = s;
    int maxLength = 1;
    for (int i = 1; i < charArray.length; i++) {
      int left = i;
      int right = i + 1;
      while (left >= 0 && right < charArray.length) {
        if (charArray[i] != charArray[i + 1]) {
          break;
        }
        maxLength++;
        if (maxLength > maxStr.length()) {
          maxStr = s.substring(left, right + 1);
        }
        left--;
        right++;
      }
      maxLength = 0;
    }
    return s;
  }

  public static void main(String[] args) {
    pro5 p = new pro5();
    System.out.println(p.longestPalindrome("babad"));
    System.out.println(p.longestPalindrome("cbbd"));
    System.out.println(p.longestPalindrome("a"));
  }
}
