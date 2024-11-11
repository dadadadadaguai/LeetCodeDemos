package com.leetcode.kama;

public class problem54 {
  public String replaceNumber(String s) {
    StringBuilder sb = new StringBuilder();
    // s字符串转列表
    char[] array = s.toCharArray();
    for (char c : array) {
      if (!Character.isDigit(c)) {
        sb.append(c);
      } else {
        sb.append("number");
      }
    }
    return sb.toString();
  }
  public static void main(String[] args){
    problem54 p = new problem54();
    String s = "a1b2c3";
    System.out.println(p.replaceNumber(s).equals("anumberbnumbercnumber"));
  }
}
