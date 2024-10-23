package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class problem202 {
  public boolean isHappy(int n) {
    Set<Integer> set = new HashSet<>();
    set.add(n);
    while (true) {
      n = getSum(n);
      if (set.contains(n)) {
        return false;
      }
      System.out.println(n);
      set.add(n);
      if (n == 1) {
        return true;
      }
    }
  }

  private int getSum(int number) {
    int sum = 0, other = 0;
    while (number != 0) {
      other = number % 10;
      number = number / 10;
      sum += other * other;
    }
    return sum;
  }

  public static void main(String[] args) {
    problem202 p = new problem202();
    System.out.println(p.isHappy(19));
  }
}
