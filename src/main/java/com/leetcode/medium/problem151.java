package com.leetcode.medium;

public class problem151 {
  public String reverseWords(String s) {
    s=s.trim();
    StringBuilder sub = new StringBuilder();
    StringBuilder res = new StringBuilder();
    int len = s.length();
    for (int i = 0; i < len; i++) {
      if (s.charAt(i) != ' ') {
        sub.append(s.charAt(i));
      } else if (sub.length() > 0) {
        res.insert(0, sub);
        res.insert(0, ' ');
        sub.setLength(0);
      }
    }
    res.insert(0, sub);
    return res.toString();
  }
  public static void main(String[] args){
    problem151 p = new problem151();
    String theSkyIsBlue = p.reverseWords("the sky is blue ");
    System.out.println(theSkyIsBlue);
  }
}
