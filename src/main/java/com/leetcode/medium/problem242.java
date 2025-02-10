package com.leetcode.medium;

import java.util.Arrays;

public class problem242 {
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    char[] charArrays = s.toCharArray();
    char[] charArrayt = t.toCharArray();
    Arrays.sort(charArrays);
    Arrays.sort(charArrayt);
    return Arrays.equals(charArrays, charArrayt);
  }

  public static void main(String[] args) {
    problem242 p = new problem242();
    System.out.println(p.isAnagram("rat", "car"));
  }
}
