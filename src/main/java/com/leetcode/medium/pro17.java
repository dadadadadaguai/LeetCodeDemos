package com.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class pro17 {
  HashMap<Integer, String> map = new HashMap<Integer, String>();
  String[] letter = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  {
    for (int i = 0; i < 8; i++) {
      map.put(i + 2, letter[i]);
    }
  }

  List<String> list = new ArrayList<String>();
  StringBuilder sb = new StringBuilder();

  public List<String> letterCombinations(String digits) {
    addPhoneNumber(digits, 0);
    return list;
  }

  private void addPhoneNumber(String digits, Integer len) {
    if (digits.isEmpty()) {
      return;
    }
    if (sb.length() == len) {
      list.add(sb.toString());
    }
    char c = digits.charAt(sb.length() - 1);
    int digit = Character.getNumericValue(c);
    String singleNum = map.get(digit);
    for (int j = 0; j < singleNum.length(); j++) {
      sb.append(singleNum.charAt(j));
      addPhoneNumber(digits, len);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
