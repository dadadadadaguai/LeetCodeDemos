package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class pro131 {
  public List<List<String>> partition(String s) {
    List<List<String>> lists = new ArrayList<>();
    ArrayList<String> path = new ArrayList<>();
    par(lists, path, s, 0, new StringBuilder());
    return lists;
  }

  private void par(
      List<List<String>> lists,
      ArrayList<String> path,
      String s,
      int startIndex,
      StringBuilder sb) {
    if (startIndex == s.length()) {
      lists.add(new ArrayList<>(path));
      return;
    }
    for (int i = startIndex; i < s.length(); i++) {
      sb.append(s.charAt(i));
      if (check(sb)) {
        path.add(sb.toString());
        par(lists, path, s, i + 1, new StringBuilder());
        path.remove(path.size()-1);
      }
    }
  }

  private boolean check(StringBuilder sb) {
    for (int i = 0; i < sb.length() / 2; i++) {
      if (sb.charAt(i) != sb.charAt(sb.length() - 1 - i)) {
        return false;
      }
    }
    return true;
  }
  public static void main(String[] args){
    pro131 p = new pro131();
    System.out.println(p.partition("aab"));
    System.out.println(p.partition("a"));
    System.out.println(p.partition("ab"));
  }
}
