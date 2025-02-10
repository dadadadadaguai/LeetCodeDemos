package com.leetcode.medium;

import java.util.Arrays;

public class pro738 {
  public int monotoneIncreasingDigits(int n) {
    String nStr = String.valueOf(n);
    char[] charArray = nStr.toCharArray();
    int len = charArray.length;
    int flag = len;
    for (int i = len - 2; i >= 0; i--) {
      if (charArray[i] > charArray[i + 1]) {
        charArray[i]--;
        flag = i + 1;
      }
    }
    for (int i = flag; i < charArray.length; i++) {
      charArray[i] = '9';
    }
    return Integer.parseInt(Arrays.toString(charArray));
  }
}
