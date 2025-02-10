package com.leetcode.doubleCompetion;

import java.util.Arrays;

public class pro1 {
  // 给你一个字符串s和一个模式字符串p,其中p恰好包含一个""符号。
  // p中的'*”符号可以被替换为零个或多个字符组成的任意字符序列。
  // 如果p可以变成s的子字符率，那么返回true,否则返回false。
  // 子字符串指的是字符率中一段连续空的字符序列。
  public boolean hasMatch(String s, String p) {
    // 将模式字符串中的 '*' 替换为 '.*'，表示任意数量的任意字符
    String regex = p.replace("*", ".*");
    // 使用正则表达式检查 s 是否包含匹配的子字符串
    return s.matches(".*" + regex + ".*");
  }

  public static void main(String[] args) {
    pro1 p = new pro1();
    //    System.out.println(p.hasMatch("luck", "u*"));
    System.out.println(p.hasMatch("leetcode", "ee*e"));
  }
}
