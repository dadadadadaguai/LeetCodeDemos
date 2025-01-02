package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class pro93 {
  public List<String> restoreIpAddresses(String s) {
    ArrayList<String> lists = new ArrayList<>();
    StringBuilder sb = new StringBuilder(s);
    restore(lists, sb, 0, 0);
    return lists;
  }

  private void restore(ArrayList<String> lists, StringBuilder sb, int startIndex, int pointNum) {
    // 结束条件
    if (pointNum == 3) {
      if (check(sb.toString(), startIndex, sb.length() - 1)) {
        lists.add(sb.toString());
      }
        return;
      }
    for (int i = startIndex; i < sb.length(); i++) {
      if (check(sb.toString(), startIndex, i)) {
        sb.insert(i + 1, '.');
        restore(lists, sb, i + 2, pointNum + 1);
        sb.deleteCharAt(i + 1);
      } else {
        break;
      }
    }
  }

  // 判断是否满足ip地址格式sb例如255.255.255.255
  private boolean check(String s, int start, int end) {
    if(start > end)
      return false;
    if(s.charAt(start) == '0' && start != end)
      return false;
    int num = 0;
    for(int i = start; i <= end; i++){
      int digit = s.charAt(i) - '0';
      num = num * 10 + digit;
      if(num > 255)
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    List<String> lists = new pro93().restoreIpAddresses("25525511135");
    for (String list : lists) {
      System.out.println(list);
    }
  }
}
