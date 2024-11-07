package com.leetcode.easy;

import java.util.Arrays;

public class problem541 {
  public String reverseStr(String s, int k) {
    char[] chars = s.toCharArray();
    int len = chars.length - 1;
    for (int i = 0; i < len; i += 2 * k) {
      reverse(chars, i, Math.min(i + k, len) - 1);
    }
    return new String(chars);
  }

  private void reverse(char[] chars, int left, int right) {
    while (left < right) {
      char temp = chars[left];
      chars[left++] = chars[right];
      chars[right--] = temp;
    }
  }

  public static void main(String[] args) {
    problem541 p = new problem541();
    String s = "abcdefg";
    int k = 2;
    System.out.println(p.reverseStr(s, k));
  }
}
