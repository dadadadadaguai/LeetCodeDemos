package com.leetcode;


import java.math.BigDecimal;

public class Main {
  public static void main(String[] args) {
    BigDecimal b1 = new BigDecimal(("1.0"));
    BigDecimal b2 = new BigDecimal("1");
    System.out.println(b1.equals(b2));
    System.out.println(b1.compareTo(b2));
  }
}
